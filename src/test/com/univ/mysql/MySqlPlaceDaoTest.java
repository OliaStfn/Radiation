package com.univ.mysql;

import com.univ.beans.Influence;
import com.univ.beans.Place;
import com.univ.beans.Position;
import com.univ.dao.AbstractDao;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MySqlPlaceDaoTest {
    @Test
    public void create() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = (Influence) dao.read(1);
        dao = factory.getDao(factory.getConnection(), Position.class);
        Position position = (Position) dao.read(1);

        dao = factory.getDao(factory.getConnection(), Place.class);
        Place place = new Place();
        place.setName("name");
        place.setDescription("there is bad here");
        place.setInfluence(influence);
        place.setPosition(position);

        Place getPlace = (Place) dao.create(place);
        assertNotNull(getPlace);
        System.out.println(getPlace.toString());
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
        Place findPlace = (Place) dao.read(1);
        assertNotNull(findPlace);
        System.out.println(findPlace.toString());
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
        ArrayList<Place> places = dao.readAll();
        assertNotNull(places);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
        Place place = (Place) dao.read(1);
        place.setName("new-name");
        dao.update(place);
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
        Place place = (Place) dao.read(2);
        dao.delete(place);
    }

}