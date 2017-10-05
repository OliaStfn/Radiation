package com.univ.beans;

import com.univ.dao.Identificator;

import java.io.Serializable;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Position implements Identificator<Long>,Serializable {
    private long id;
    private int longitudeDegree;
    private int latitudeDegree;
    private int longitudeMinute;
    private int latitudeMinute;

    public Position() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLongitudeDegree() {
        return longitudeDegree;
    }

    public void setLongitudeDegree(int longitudeDegree) {
        this.longitudeDegree = longitudeDegree;
    }

    public int getLatitudeDegree() {
        return latitudeDegree;
    }

    public void setLatitudeDegree(int latitudeDegree) {
        this.latitudeDegree = latitudeDegree;
    }

    public int getLongitudeMinute() {
        return longitudeMinute;
    }

    public void setLongitudeMinute(int longitudeMinute) {
        this.longitudeMinute = longitudeMinute;
    }

    public int getLatitudeMinute() {
        return latitudeMinute;
    }

    public void setLatitudeMinute(int latitudeMinute) {
        this.latitudeMinute = latitudeMinute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (longitudeDegree != position.longitudeDegree) return false;
        if (latitudeDegree != position.latitudeDegree) return false;
        if (longitudeMinute != position.longitudeMinute) return false;
        return latitudeMinute == position.latitudeMinute;
    }

    @Override
    public int hashCode() {
        int result = longitudeDegree;
        result = 31 * result + latitudeDegree;
        result = 31 * result + longitudeMinute;
        result = 31 * result + latitudeMinute;
        return result;
    }
}
