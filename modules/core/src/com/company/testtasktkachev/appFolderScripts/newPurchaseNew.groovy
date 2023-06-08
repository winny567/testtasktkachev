/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */
//package com.company.testtasktkachev.appFolderScripts

import com.company.testtasktkachev.entity.VehiclePurchaseRequisition
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.UserSessionSource
import com.haulmont.workflow.core.entity.Proc

def userName = AppBeans.get(UserSessionSource.class).getUserSession().getCurrentOrSubstitutedUser().getLogin()
def dataManager = AppBeans.get(DataManager.class)
def proc = dataManager.load(Proc.class)
        .query("select p from wf\$Proc p where p.code = :code")
        .parameter("code", "application_approval")
        .one()
def procId = proc == null ? null : proc.getId()

def result = dataManager.load(VehiclePurchaseRequisition.class)
        .query("select c from testtasktkachev\$VehiclePurchaseRequisition c where c.createdBy = :name and c.proc.id <> :procId")
        .parameter("name", userName)
        .parameter("procId", procId)
        .list()

if (result.isEmpty()) {
    return []
}
return result