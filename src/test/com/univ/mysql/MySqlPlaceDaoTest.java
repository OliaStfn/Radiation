package com.univ.mysql;

import com.univ.beans.Influence;
import com.univ.beans.Place;
import com.univ.dao.AbstractDao;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MySqlPlaceDaoTest {
    @Test
    public void create() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = (Influence) dao.read(4);

        dao = factory.getDao(factory.getConnection(), Place.class);
        Place place = new Place();
        place.setName("Львів");
        place.setDescription("");
        place.setLatitude(49.62);
        place.setLongitude(32.74);
        place.setInfluence(influence);


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
        Place place = (Place) dao.read(4);
        place.setLatitude(89.50);
        dao.update(place);
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Place.class);
        Place place = (Place) dao.read(4);
        dao.delete(place);
    }
}