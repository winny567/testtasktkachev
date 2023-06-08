/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.core.app.reassignment.commands;

import com.haulmont.thesis.core.app.reassignment.commands.AbstractDocReassignmentCommand;
import com.company.testtasktkachev.entity.VehiclePurchaseRequisition;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(VehiclePurchaseRequisitionReassignmentCommand.NAME)
public class VehiclePurchaseRequisitionReassignmentCommand extends AbstractDocReassignmentCommand<VehiclePurchaseRequisition> {
    protected static final String NAME = "testtasktkachev_VehiclePurchaseRequisitionReassignmentCommand";

    @PostConstruct
    protected void postInit() {
        type = "VehiclePurchaseRequisition";
        docQuery = String.format(DOC_QUERY_TEMPLATE, "testtasktkachev$VehiclePurchaseRequisition");
    }

    @Override
    public String getName() {
        return NAME;
    }
}