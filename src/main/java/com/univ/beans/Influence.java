package com.univ.beans;

import com.univ.dao.Identificator;

import java.io.Serializable;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Influence implements Identificator<Long>, Serializable {
    private long id;
    //some fields
    private long radiationId;

    public Influence() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRadiationId() {
        return radiationId;
    }

    public void setRadiationId(long radiationId) {
        this.radiationId = radiationId;
    }
}
