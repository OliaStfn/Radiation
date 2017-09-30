package com.univ.beans;

import com.univ.dao.Identificator;

import java.io.Serializable;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Influence implements Identificator<Long>, Serializable {
    private long id;
    private int probabilityOfMutation; //in percent
    private int percentageOfContamination; //in percent
    private Radiation radiation;

    public Influence() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getProbabilityOfMutation() {
        return probabilityOfMutation;
    }

    public void setProbabilityOfMutation(int probabilityOfMutation) {
        this.probabilityOfMutation = probabilityOfMutation;
    }

    public int getPercentageOfContamination() {
        return percentageOfContamination;
    }

    public void setPercentageOfContamination(int percentageOfContamination) {
        this.percentageOfContamination = percentageOfContamination;
    }

    public Radiation getRadiation() {
        return radiation;
    }

    public void setRadiation(Radiation radiation) {
        this.radiation = radiation;
    }
}
