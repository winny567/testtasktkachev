/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum CarType implements EnumClass<String> {

    CROSSOVER("crossover"),
    UNIVERSAL("universal"),
    SEDAN("sedan");

    private String id;

    CarType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CarType fromId(String id) {
        for (CarType at : CarType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}