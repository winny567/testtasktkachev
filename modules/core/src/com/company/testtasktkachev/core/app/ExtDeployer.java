package com.company.testtasktkachev.core.app;

import com.google.common.collect.Lists;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.app.ServerConfig;
import com.haulmont.cuba.core.entity.Config;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.security.app.Authenticated;
import com.haulmont.cuba.security.app.EntityLogAPI;
import com.haulmont.cuba.security.entity.Role;
import com.haulmont.reports.entity.Report;
import com.haulmont.reports.entity.ReportScreen;
import com.haulmont.thesis.core.app.AbstractDeployer;
import com.haulmont.thesis.core.app.filter.FilterDeploymentTools;
import com.haulmont.workflow.core.entity.Proc;
import com.haulmont.workflow.core.entity.ProcRole;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component("testtasktkachev_ExtDeployer")
public class ExtDeployer extends AbstractDeployer implements ExtDeployerMBean {

    protected Log log = LogFactory.getLog(ExtDeployer.class);
    @Inject
    protected EntityLogAPI entityLogAPI;
    @Inject
    protected FilterDeploymentTools filterDeploymentTools;
    @Inject
    protected Messages messages;

    public ExtDeployer() {
        createAppContextListener();
    }

    protected void createAppContextListener() {
        AppContext.addListener(new AppContext.Listener() {
            public void applicationStarted() {
                checkForFirstInit();
            }

            public void applicationStopped() {
            }
        });
    }

    protected void checkForFirstInit() {
        Transaction tx = persistence.createTransaction();
        try {
            EntityManager em = persistence.getEntityManager();
            String initDefaultInFirstStart = em.createQuery(
                    "select c.value from sys$Config c " +
                            "where c.name='testtasktkachev.initDefaultInFirstStart'",
                    String.class).getFirstResult();

            if (initDefaultInFirstStart == null || Boolean.parseBoolean(initDefaultInFirstStart)) {
                String edition = AppContext.getProperty("thesis.initDefaultEdition");
                if (StringUtils.isNotBlank(edition) && Integer.parseInt(edition) > 1) {
                    initDefault("init");
                    if (initDefaultInFirstStart == null) {
                        try {
                            authentication.begin();
                            Config config =  metadata.create(Config.class);
                            config.setName("testtasktkachev.initDefaultInFirstStart");
                            config.setValue("false");
                            em.persist(config);
                            tx.commit();
                        } finally {
                            authentication.end();
                        }
                    } else {
                        try {
                            authentication.begin();
                            em.createQuery("update sys$Config c set c.value='false' where c.name='testtasktkachev.initDefaultInFirstStart'",
                                    Config.class).executeUpdate();
                            tx.commit();
                        } finally {
                            authentication.end();
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("Exception during defaults initialization", e);
            throw (e);
        } finally {
            tx.end();
        }
    }

    @Authenticated
    public String initDefault(String password) {
        if (password != null && initDefaultPassword.equals(DigestUtils.md5Hex(password))) {
            try {
                log.info("Init default");
                executeInitScripts();
                initExtensionDocumentsFunctionality();
                initStandardFilters();
                entityLogAPI.invalidateCache();
                return INIT_SUCESS;
            } catch (Exception e) {
                return ExceptionUtils.getStackTrace(e);
            }
        }
        return "Error password";
    }

    protected void executeInitScripts() {
        log.info("Execute init scripts");
        String dbDirPath = configuration.getConfig(ServerConfig.class).getDbDir();
        String dbmsType = AppContext.getProperty("cuba.dbmsType");
        File folderDB = new File(dbDirPath + "/50-testtasktkachev/init/" + dbmsType);
        File[] scripts = folderDB.listFiles();
        if (ArrayUtils.isNotEmpty(scripts)) {
            for (File script : scripts) {
                if (script.getName().contains("init")) {
                    executeSqlScript(script);
                }
            }
        } else {
            log.info("There is no init scripts found");
        }
    }


    public void initExtensionDocumentsFunctionality() {
        log.info("Init extension documents functionality");
        ArrayList<String> procCodes = Lists.newArrayList("Endorsement", "Resolution", "Acquaintance", "Registration");
        ArrayList<String> reportCodes = Lists.newArrayList("EndorsementList");

        String extensionDocuments = AppContext.getProperty("ext.extensionDocuments");
        if (StringUtils.isEmpty(extensionDocuments)) {
            log.info("There is no extension documents found");
            return;
        }

        String[] extDocMetaClasses = StringUtils.split(extensionDocuments, ", \t\n\f\r");
        Transaction tx = persistence.getTransaction();
        try {
            EntityManager em = persistence.getEntityManager();
            List<Proc> procs = em
                    .createQuery("select p from wf$Proc p where p.code in :procCodes", Proc.class)
                    .setParameter("procCodes", procCodes)
                    .getResultList();

            for (Proc proc : procs) {
                StringBuilder cardTypes = new StringBuilder(proc.getCardTypes());
                for (String metaClass : extDocMetaClasses)
                    if (cardTypes.indexOf(metaClass) == -1)
                        cardTypes.append(metaClass).append(",");

                proc.setCardTypes(cardTypes.toString());
            }

            List<Report> reports = em
                    .createQuery("select r from report$Report r where r.code in :reportCodes", Report.class)
                    .setParameter("reportCodes", reportCodes)
                    .getResultList();

            for (Report report : reports) {
                Report reportFromXml = reportingApi.convertToReport(report.getXml());
                List<ReportScreen> reportScreens = reportFromXml.getReportScreens();

                for (String metaClass : extDocMetaClasses) {
                    final String screenId = metaClass + ".edit";
                    Optional<ReportScreen> oReportScreen = reportScreens
                            .stream()
                            .filter(r -> screenId.equals(r.getScreenId()))
                            .findFirst();

                    if (!oReportScreen.isPresent()) {
                        ReportScreen reportScreen = metadata.create(ReportScreen.class);
                        reportScreen.setReport(reportFromXml);
                        reportScreen.setScreenId(screenId);
                        reportScreens.add(reportScreen);
                    }
                }

                reportFromXml.setReportScreens(reportScreens);
                report.setXml(reportingApi.convertToString(reportFromXml));
            }
            tx.commit();
        } catch (Exception e) {
            throw new RuntimeException("Error during initialization of extension documents functionality", e);
        } finally {
            tx.end();
        }
        log.info("Extension documents functionality was added to " + extensionDocuments);
    }

    public void initStandardFilters() {
        log.info("Init standard filters");
        String filtersDirPath = AppContext.getProperty("ext.filtersDir");
        if (StringUtils.isEmpty(filtersDirPath)) {
            log.info("'ext.filtersDir' property is not set");
            return;
        }
        File filtersDir = new File(filtersDirPath);
        if (!filtersDir.exists()) {
            log.info("Folders dir " + filtersDirPath + " not found");
            return;
        }
        File[] filters = filtersDir.listFiles((dir, name) -> name.endsWith(".xml"));
        if (!ArrayUtils.isEmpty(filters)) {
            StringBuilder resultMessage = new StringBuilder();
            Arrays.sort(filters);
            createFilterEntities(filters, resultMessage);
            log.info(resultMessage);
        }
    }

    protected void createFilterEntities(File[] filters, StringBuilder resultMessage) {
        Transaction tx = persistence.createTransaction();
        try {
            authentication.begin();
            for (File filterXml : filters) {
                filterDeploymentTools.deployFiltersFromFile(filterXml, resultMessage);
            }
            tx.commit();
        } catch (Exception e) {
            throw new RuntimeException("Error during initialization of standard filter", e);
        } finally {
            tx.end();
            authentication.end();
        }
    }

    @Override
    @Authenticated
    public String deployApprovalRequestsProcess() {
        String result = deployProcesses(Collections.singletonList("Утверждение заявки"));
        persistence.createTransaction().execute(new Transaction.Callable<Object>() {
            @Override
            public Object call(EntityManager em) {
                Proc proc = (Proc) em.createQuery("select p from wf$Proc p where p.name = :name")
                        .setParameter("name", "Утверждение заявки")
                        .setView(Proc.class, "edit")
                        .getFirstResult();
                if (proc != null) {
                    proc.setCode("application_approval");
                    proc.setCardTypes(",testtasktkachev$VehiclePurchaseRequisition,");
                    Role roleOperatorBank = (Role) em.createQuery("select r from sec$Role r where " +
                            "r.name = 'operator_bank'").getFirstResult();
                    Role roleManagerSalon = (Role) em.createQuery("select r from sec$Role r where " +
                            "r.name = 'manager_salon'").getFirstResult();
                    Role roleMaster = (Role) em.createQuery("select r from sec$Role r where " +
                            "r.name = 'master'").getFirstResult();
                    for (ProcRole procRole : proc.getRoles()) {
                        switch (procRole.getCode()) {
                            case "Оператор банка":
                                procRole.setRole(roleOperatorBank);
                                procRole.setSortOrder(0);
                                break;
                            case "Менеджер салона":
                                procRole.setRole(roleManagerSalon);
                                procRole.setSortOrder(1);
                                break;
                            case "Мастер":
                                procRole.setRole(roleMaster);
                                procRole.setSortOrder(2);
                                break;
                        }
                        procRole.setName(messages.getMessage(getClass(), procRole.getCode()));
                    }
                    em.merge(proc);
                }
                return null;
            }
        });
        return result;
    }

}