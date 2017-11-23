package com.univ.beans;

import com.univ.dao.Identificator;

import java.io.Serializable;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Place implements Identificator<Long>, Serializable {
    private long id;
    private String name;
    private String description;
    private String latitude;
    private String longitude;
    private Influence influence;

    public Place() {
        id = 0;
        name = "none";
        description = "none";
        latitude = "none";
        longitude = "none";
        influence = new Influence();
    }

    public Place(String name, String description, String latitude,
                 String longitude) {
        this.id = 0;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.influence = new Influence();
    }

    @Override
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Influence getInfluence() {
        return influence;
    }

    public void setInfluence(Influence influence) {
        this.influence = influence;
    }
}
