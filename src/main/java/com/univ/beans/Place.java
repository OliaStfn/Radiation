package com.univ.beans;

import com.univ.dao.Identificator;

import java.io.Serializable;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Place implements Identificator<Long>,Serializable {
    private long id;
    private String name;
    private String description;
    private Position position;
    private Influence influence;

    public Place() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Influence getInfluence() {
        return influence;
    }

    public void setInfluence(Influence influence) {
        this.influence = influence;
    }
}
