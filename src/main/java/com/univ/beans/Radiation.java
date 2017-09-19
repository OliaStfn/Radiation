package com.univ.beans;

/**
 * Created by Олюнь on 17.09.2017.
 */

import com.univ.dao.Identificator;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * radiation - in x-rays
 */
public class Radiation implements Identificator<Long>,Serializable {
    private long id;
    private double radiation;
    private String advantageType;
    private LocalDate lastUpdateDate;

    public Radiation() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRadiation() {
        return radiation;
    }

    public void setRadiation(double radiation) {
        this.radiation = radiation;
    }

    public String getAdvantageType() {
        return advantageType;
    }

    public void setAdvantageType(String advantageType) {
        this.advantageType = advantageType;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
