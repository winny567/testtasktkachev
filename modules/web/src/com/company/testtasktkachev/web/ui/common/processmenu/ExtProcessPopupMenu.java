/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.web.ui.common.processmenu;

import com.company.testtasktkachev.entity.VehiclePurchaseRequisition;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.data.CollectionDatasource;
import com.haulmont.cuba.security.global.UserSession;
import com.haulmont.thesis.core.app.UserSessionTools;
import com.haulmont.thesis.web.ui.common.processmenu.ProcessMenuAdditionalParams;
import com.haulmont.thesis.web.ui.common.processmenu.ProcessPopupMenu;
import com.haulmont.thesis.web.ui.common.processmenu.ProcessedCardsHolder;
import com.haulmont.workflow.core.entity.Card;

import java.util.List;

public class ExtProcessPopupMenu extends ProcessPopupMenu {

    @Override
    public List<Action> createPopActions(Card card, CollectionDatasource collectionDatasource, ProcessedCardsHolder processedCardsHolder, ProcessMenuAdditionalParams params) {
        List<Action> popActions = super.createPopActions(card, collectionDatasource, processedCardsHolder, params);
        if (card instanceof VehiclePurchaseRequisition) {
            VehiclePurchaseRequisition doc = (VehiclePurchaseRequisition) card;
            if (isUserAnyRoleOperatorBank() && !doc.getIsPayCar()) {
                for (Action popAction : popActions) {
                    popAction.setEnabled(false);
                }
                return popActions;
            }
        }
        return popActions;
    }

    private boolean isUserAnyRoleOperatorBank() {
        UserSessionTools userSessionTools = AppBeans.get(UserSessionTools.class);
        UserSession userSession = AppBeans.get(UserSession.class);

        return userSessionTools.isSessionUserInAnyRole(userSession, "operator_bank");
    }
}
