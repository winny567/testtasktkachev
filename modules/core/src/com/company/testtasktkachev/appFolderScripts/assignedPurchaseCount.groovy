/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */
package com.company.testtasktkachev.appFolderScripts

import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.UserSessionSource
import com.haulmont.thesis.core.appfolders.hazelcast.HazelcastCacheOperation

def userId = AppBeans.get(UserSessionSource.class).currentOrSubstitutedUserId()

def cardsWithAssignmentsCnt = 0
def cardsWithCardInfoCnt = 0
def procStatesMap = [:]


procStatesMap << ['application_approval' : ['Podgotovka','Proverka_dokumentov','Proverka_zayavki',]]


HazelcastCacheOperation operation = AppBeans.get(HazelcastCacheOperation.class)
counterObject = operation.cardMetaClass('testtasktkachev$VehiclePurchaseRequisition')
        .userInCurrentActors(userId)
        .processCodesAndStates(procStatesMap)
        .withHasCardInfoPredicate(userId)
        .submitToCount()

cardsWithAssignmentsCnt = counterObject.assignmentsQuantity
cardsWithCardInfoCnt = counterObject.cardInfoQuantity
counterObject.folder = folder

style = (cardsWithCardInfoCnt > 0) ? 'cardremind' : null
return cardsWithAssignmentsCnt