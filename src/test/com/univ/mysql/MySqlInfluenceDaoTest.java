package com.univ.mysql;

import com.univ.beans.Element;
import com.univ.beans.Influence;
import com.univ.dao.AbstractDao;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class MySqlInfluenceDaoTest {
    /*@Test
    public void create() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Element.class);
        Element element = (Element) dao.read(4);

        dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = new Influence();
        influence.setRadiation(13);
        influence.setLastUpdateTime(LocalDateTime.now());
        influence.setElement(element);
        Influence getInfluence = (Influence) dao.create(influence);
        assertNotNull(getInfluence);
        System.out.println(getInfluence.toString());
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence findInfluence = (Influence) dao.read(1);
        assertNotNull(findInfluence);
        System.out.println(findInfluence.toString());
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        ArrayList<Influence> influences = dao.readAll();
        assertNotNull(influences);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = (Influence) dao.read(1);
        influence.setLastUpdateTime(LocalDateTime.now());
        dao.update(influence);
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = (Influence) dao.read(4);
        dao.delete(influence);
    }*/
}