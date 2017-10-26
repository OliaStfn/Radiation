package com.univ.sevices;

import com.univ.beans.*;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;
import com.univ.dao.DaoFactory;
import com.univ.mysql.MySqlDaoFactory;

import java.util.ArrayList;
import java.util.HashSet;

public class PlaceService implements IPlaceService {
    @Override
    public Place getPlaceByCoordinate(Position position) {
        DaoFactory factory = new MySqlDaoFactory();
        Place result = null;
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            ArrayList<Place> places = dao.readAll();
            for (Place place : places) {
                if (place.getPosition().equals(position))
                    result = place;
            }
        } catch (DaoException e) {
            //TODO: log
        }
        return result;
    }

    @Override
    public Place getPlaceByName(String name) {
        DaoFactory factory = new MySqlDaoFactory();
        Place result = null;
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            ArrayList<Place> places = dao.readAll();
            for (Place place : places) {
                if (place.getName().equals(name))
                    result = place;
            }
        } catch (DaoException e) {
            //TODO: log
        }
        return result;
    }

    @Override
    public void addNewPlace(Place place, Position position, Influence influence) {
        DaoFactory factory = new MySqlDaoFactory();
        IInfluenceService service = new InfluenceService();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            place.setInfluence(service.addInfluence(influence));
            place.setPosition(addPosition(position));
            dao.create(place);
        } catch (DaoException e) {
            //TODO: log
        }
    }

    @Override
    public void addPlaceWithApproximation(Place place, Position position) {
        //TODO: check method and change
        DaoFactory factory = new MySqlDaoFactory();
        IInfluenceService service = new InfluenceService();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);

            HashSet<Influence> nearPositions = new HashSet<>();
            int difference = 1;
            while (nearPositions.size() < 20 && difference < 10) {
                Position nearPosition = position;
                nearPosition.setLatitudeMinute(nearPosition.getLatitudeMinute() + difference);
                Place temp = getPlaceByCoordinate(nearPosition);
                if (temp != null) nearPositions.add(temp.getInfluence());

                nearPosition = position;
                nearPosition.setLatitudeMinute(nearPosition.getLatitudeMinute() - difference);
                temp = getPlaceByCoordinate(nearPosition);
                if (temp != null) nearPositions.add(temp.getInfluence());

                nearPosition = position;
                nearPosition.setLongitudeMinute(nearPosition.getLongitudeMinute() + difference);
                temp = getPlaceByCoordinate(nearPosition);
                if (temp != null) nearPositions.add(temp.getInfluence());

                nearPosition = position;
                nearPosition.setLongitudeMinute(nearPosition.getLongitudeMinute() - difference);
                temp = getPlaceByCoordinate(nearPosition);
                if (temp != null) nearPositions.add(temp.getInfluence());

                difference++;
            }
            place.setPosition(addPosition(position));
            place.setInfluence(service.approximation(nearPositions));
            dao.create(place);
        } catch (DaoException e) {
            //TODO: log
        }
    }

    @Override
    public Position addPosition(Position position) {
        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Position.class);
            position = (Position) dao.create(position);
        } catch (DaoException e) {
            //TODO: log
        }
        return position;
    }

    @Override
    public void removePlace(Place place) {
        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            dao.delete(place);
        } catch (DaoException e) {
            //TODO: log
        }
    }

    @Override
    public void changeInfoAboutPlace(Place place) {
        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
            dao.update(place);
        } catch (DaoException e) {
            //TODO: log
        }
    }

    @Override
    public ArrayList<Place> topTheBestPlace(int count) {
        return null;
    }

    @Override
    public ArrayList<Place> topTheWorstPlace(int count) {
        return null;
    }

    @Override
    public Recommendation getRecommendationForPlace(String name) {
        Place place = getPlaceByName(name);
        Influence influence = place.getInfluence();
        IInfluenceService service = new InfluenceService();

        return service.getRecommendation(influence);
    }

    @Override
    public Recommendation getRecommendationForPosition(Position position) {
        Place place = getPlaceByCoordinate(position);
        Influence influence = place.getInfluence();
        IInfluenceService service = new InfluenceService();

        return service.getRecommendation(influence);
    }
}
