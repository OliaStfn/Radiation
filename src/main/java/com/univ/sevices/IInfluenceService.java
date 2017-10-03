package com.univ.sevices;

import com.univ.beans.Influence;
import com.univ.beans.Radiation;
import com.univ.beans.Recommendation;

import java.util.HashSet;

public interface IInfluenceService {
    Influence addInfluence(Influence influence);

    Radiation addRadiation(Radiation radiation);

    void autoChangeInfluence();

    void changeInfluence(Influence influence);

    Influence approximation(HashSet<Influence> nearPositions);

    void setMutation(Influence influence);

    Recommendation getRecommendation(Influence influence);
}
