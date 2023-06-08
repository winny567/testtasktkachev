/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.thesis.core.entity.Contractor;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Objects;

@Service(OrderService.NAME)
public class OrderServiceBean implements OrderService {

    @Inject
    private Persistence persistence;

    @Override
    public String getCountRequisition(Contractor contractor) {
        String countRequisition;

        try (Transaction tx = persistence.createTransaction()){
            EntityManager em = persistence.getEntityManager();

            countRequisition = Objects.requireNonNull(em.createQuery("select count(e) from testtasktkachev$VehiclePurchaseRequisition e where e.contractor.id = :contractorId")
                    .setParameter("contractorId", contractor.getId()).getFirstResult()).toString();

            tx.commit();
        }

        return countRequisition;
    }
}