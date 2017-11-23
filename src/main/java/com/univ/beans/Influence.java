package com.univ.beans;

import com.univ.dao.Identificator;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Influence implements Identificator<Long>, Serializable {
    private long id;
    private int percentageOfContamination; //in percent
    private double radiation;
    private long radioactiveElementId;
    private LocalDateTime lastUpdateTime;

    public Influence() {
        id=0;
        percentageOfContamination=0;
        radiation=0;
        radioactiveElementId=0;
        lastUpdateTime=LocalDateTime.now();
    }

    public Influence(int percentageOfContamination, double radiation, long radioactiveElementId) {
        this.id = 0;
        this.percentageOfContamination = percentageOfContamination;
        this.radiation = radiation;
        this.radioactiveElementId = radioactiveElementId;
        this.lastUpdateTime = LocalDateTime.now();
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPercentageOfContamination() {
        return percentageOfContamination;
    }

    public void setPercentageOfContamination(int percentageOfContamination) {
        this.percentageOfContamination = percentageOfContamination;
    }

    public double getRadiation() {
        return radiation;
    }

    public void setRadiation(double radiation) {
        this.radiation = radiation;
    }

    public long getRadioactiveElementId() {
        return radioactiveElementId;
    }

    public void setRadioactiveElementId(long radioactiveElementId) {
        this.radioactiveElementId = radioactiveElementId;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
