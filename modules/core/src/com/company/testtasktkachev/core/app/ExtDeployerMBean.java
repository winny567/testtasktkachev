package com.company.testtasktkachev.core.app;

import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.jmx.export.annotation.*;
import com.haulmont.cuba.core.sys.jmx.JmxBean;

@JmxBean(module = "testtasktkachev", alias = "ExtDeployer")
@ManagedResource(description = "Used to initialize THESIS specific components (processes, reports, filters and so on).")
public interface ExtDeployerMBean {
    @ManagedOperation(description = "Initialize functionality for extended documents (add Card types to procs, add screens to EndorecementList Report, init Filters)")
    @ManagedOperationParameters({@ManagedOperationParameter(name = "password", description = "Password")})
    String initDefault(String password);

    @ManagedOperation(description = "Deploy process Approval Requests")
    @Authenticated
    String deployApprovalRequestsProcess();
}