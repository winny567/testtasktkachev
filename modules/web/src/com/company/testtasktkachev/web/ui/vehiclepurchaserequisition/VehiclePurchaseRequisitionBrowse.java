package com.company.testtasktkachev.web.ui.vehiclepurchaserequisition;

import com.company.testtasktkachev.entity.VehiclePurchaseRequisition;
import com.haulmont.thesis.web.ui.basicdoc.browse.AbstractDocBrowser;

import java.util.Map;

public class VehiclePurchaseRequisitionBrowse<T extends VehiclePurchaseRequisition> extends AbstractDocBrowser<T> {
    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        entityName = "testtasktkachev$VehiclePurchaseRequisition";
    }
}