/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.web.ui.vehiclepurchaserequisition;

import com.haulmont.thesis.web.ui.basicdoc.browse.AbstractDocBrowser;
import com.company.testtasktkachev.entity.VehiclePurchaseRequisition;

import java.util.Map;

public class VehiclePurchaseRequisitionBrowse<T extends VehiclePurchaseRequisition> extends AbstractDocBrowser<T> {
    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        entityName = "testtasktkachev$VehiclePurchaseRequisition";
    }
}