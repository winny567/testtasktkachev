/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.testtasktkachev.appFolderScripts

import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.UserSessionSource
import com.haulmont.thesis.core.appfolders.AppFolderCardsSelector

def userId = AppBeans.get(UserSessionSource.class).currentOrSubstitutedUserId()
def procStatesMap = [:]

procStatesMap << ['application_approval' : ['Podgotovka','Proverka_dokumentov','Proverka_zayavki',]]

return AppFolderCardsSelector.get().selectCardsByProcessAndState('testtasktkachev$VehiclePurchaseRequisition', userId, procStatesMap)