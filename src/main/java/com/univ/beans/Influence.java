package com.univ.beans;

import com.univ.dao.Identificator;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Influence implements Identificator<Long>, Serializable {
    private long id;
    private double radiation;
    private Element element;
    private LocalDateTime lastUpdateTime;

    public Influence() {
        id = 0;
        radiation = 0;
        element = new Element();
        lastUpdateTime = LocalDateTime.now();
    }

    public Influence(double radiation, Element element) {
        this.id = 0;
        this.radiation = radiation;
        this.element = element;
        this.lastUpdateTime = LocalDateTime.now();
    }

    @Override
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

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void update() {
        //TODO
    }
}
