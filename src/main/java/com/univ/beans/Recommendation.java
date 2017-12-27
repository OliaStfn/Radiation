package com.univ.beans;

public class Recommendation {
    private String decision;
    private Influence influence;

    public Recommendation(Place place) {
        decision = "";
        influence = place.getInfluence();
    }

    public String getDecision() {
        canLive();
        needDefence();
        damage();

        return decision;
    }

    private void canLive() {
        decision += "";
    }

    private void needDefence() {
        decision += "";
    }

    private void damage() {
        decision += "";
    }
}