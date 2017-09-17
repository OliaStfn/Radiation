package com.univ.beans;

/**
 * Created by Олюнь on 17.09.2017.
 */
public class Place {
    private long id;
    private String name;
    private String description;
    private long positionId;
    private long influenceId;

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

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public long getInfluenceId() {
        return influenceId;
    }

    public void setInfluenceId(long influenceId) {
        this.influenceId = influenceId;
    }
}
