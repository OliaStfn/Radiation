package com.univ.sevices;

import com.univ.beans.Influence;
import com.univ.beans.Place;
import com.univ.beans.Position;
import com.univ.beans.Recommendation;

import java.util.ArrayList;

public interface IPlaceService {
    Place getPlaceByCoordinate(Position position);

    Place getPlaceByName(String name);

    void addNewPlace(Place place, Position position, Influence influence);

    void addPlaceWithApproximation(Place place, Position position);

    Position addPosition(Position position);

    void removePlace(Place place);

    void changeInfoAboutPlace(Place place);

    ArrayList<Place> topTheBestPlace(int count);

    ArrayList<Place> topTheWorstPlace(int count);

    Recommendation getRecommendationForPlace(String name);

    Recommendation getRecommendationForPosition(Position position);
}
