/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.web.ui;

import com.company.testtasktkachev.service.OrderService;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.thesis.web.ui.individual.IndividualBrowseFrame;

import javax.inject.Inject;

public class ExtIndividualBrowseFrame extends IndividualBrowseFrame {

    @Inject
    protected OrderService orderService;

    @Subscribe
    public void onInit(InitEvent event) {
        individualsTable.addGeneratedColumn("countRequisition",
                entity -> new Table.PlainTextCell(orderService.getCountRequisition(entity) != null
                        ? orderService.getCountRequisition(entity)
                        : "0"));
    }
}