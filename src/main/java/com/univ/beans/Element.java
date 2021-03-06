package com.univ.beans;

import com.univ.dao.Identificator;

public class Element implements Identificator<Long> {
    private long id;
    private String radioactiveElement;
    private String name;
    private int mass;

    public Element() {
        id = 0;
        radioactiveElement = "none";
        name = "none";
        mass = 0;
    }

    public Element(String radioactiveElement, String name, int mass) {
        this.id = 0;
        this.radioactiveElement = radioactiveElement;
        this.name = name;
        this.mass = mass;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRadioactiveElement() {
        return radioactiveElement;
    }

    public void setRadioactiveElement(String radioactiveElement) {
        this.radioactiveElement = radioactiveElement;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}