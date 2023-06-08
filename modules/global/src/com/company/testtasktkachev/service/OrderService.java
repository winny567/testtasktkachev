/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.service;

import com.haulmont.thesis.core.entity.Contractor;
import com.haulmont.thesis.core.entity.Individual;

public interface OrderService {
    String NAME = "testtasktkachev_OrderService";

    String getCountRequisition(Contractor contractor);
}