/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.testtasktkachev.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EnableRestore;
import com.haulmont.cuba.core.entity.annotation.TrackEditScreenHistory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "TESTTASKTKACHEV_CAR_MODEL")
@Entity(name = "testtasktkachev$CarModel")
@EnableRestore
@TrackEditScreenHistory
@NamePattern("%s|name")
public class CarModel extends StandardEntity {

    private static final long serialVersionUID = 6545343479220093436L;

    @Column(name = "NAME", length = 250)
    protected String name;

    @Column(name = "CODE", length = 100)
    protected String code;

    @Column(name = "NOTE", length = 500)
    protected String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}