package com.company.testtasktkachev.web.ui.vehiclepurchaserequisition;

import com.company.testtasktkachev.entity.VehiclePurchaseRequisition;
import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.thesis.core.entity.DocCategory;
import com.haulmont.thesis.web.actions.PrintReportAction;
import com.haulmont.thesis.web.ui.basicdoc.editor.AbstractDocEditor;
import com.haulmont.thesis.web.voice.VoiceActionPriorities;

import javax.inject.Inject;
import java.util.Map;

import static com.haulmont.thesis.web.voice.VoiceCompanionsRepository.voiceCompanion;

public class VehiclePurchaseRequisitionEdit<T extends VehiclePurchaseRequisition> extends AbstractDocEditor<T> {

    @Inject
    protected LookupPickerField<DocCategory> docCategory;
    @Inject
    protected CheckBox isPayCarCheckBox;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initVoiceControl();
    }

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        if (isUserAnyRoleOperatorBank() && !isPayCarCheckBox.isChecked()) {
            isPayCarCheckBox.setEditable(true);
        }
    }

    @Subscribe
    protected void onAfterInit(AfterInitEvent event) {
        if (isUserAnyRoleOperatorBank() && !isPayCarCheckBox.isChecked()) {
            actionsFrame.getProcActionsContainer().setEnabled(false);
        }
    }

    private boolean isUserAnyRoleOperatorBank() {
        return userSessionTools.isSessionUserInAnyRole(userSession, "operator_bank");
    }

    @Override
    protected String getHiddenTabsConfig() {
        return "processTab,openHistoryTab,securityTab,cardProjectsTab,correspondenceHistoryTab,docTransferLogTab,cardLinksTab,docLogTab,versionsTab";
    }

    @Override
    protected void addPrintDocActions() {
        super.addPrintDocActions();
        printButton.addAction(new PrintReportAction("printExecutionList", this, "printDocExecutionListReportName"));
    }

    protected void initVoiceControl() {
        voiceCompanion(docCategory).setPriorityOffset(VoiceActionPriorities.TAB_SHEET + 10);
    }

    @Override
    protected void fillHiddenTabs() {
        hiddenTabs.put("office", getMessage("office"));
        hiddenTabs.put("attachmentsTab", getMessage("attachmentsTab"));
        hiddenTabs.put("docTreeTab", getMessage("docTreeTab"));
        if (getAccessData().getNotVersion()) {
            hiddenTabs.put("cardCommentTab", getMessage("cardCommentTab"));
        }
        super.fillHiddenTabs();
    }

    @Subscribe("isPayCarCheckBox")
    protected void onIsPayCarCheckBoxValueChange(HasValue.ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            actionsFrame.getProcActionsContainer().setEnabled(true);
        } else {
            actionsFrame.getProcActionsContainer().setEnabled(false);
        }
    }
    
    
}