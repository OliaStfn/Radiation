package com.univ.beans;

/**
 * Created by Олюнь on 17.09.2017.
 */

/**
 * radiation - in x-rays
 */
public class Radiation {
    private long id;
    private double radiation;
    private String advantetype;

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

    public String getAdvantetype() {
        return advantetype;
    }

    public void setAdvantetype(String advantetype) {
        this.advantetype = advantetype;
    }
}
