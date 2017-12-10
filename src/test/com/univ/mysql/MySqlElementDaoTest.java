package com.univ.mysql;

import com.univ.beans.Element;
import com.univ.dao.AbstractDao;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MySqlElementDaoTest {
    @Test
    public void create() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Element.class);
        Element element = new Element();
        element.setRadioactiveElement("Am");
        element.setName("Америцій");
        element.setMass(241);
        Element getEl = (Element) dao.create(element);

        assertNotNull(getEl);
        System.out.println(element.toString());
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Element.class);
        Element findelement = (Element) dao.read(1);
        assertNotNull(findelement);
        System.out.println(findelement.toString());
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Element.class);
        ArrayList<Element> elementArrayList = dao.readAll();
        assertNotNull(elementArrayList);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Element.class);
        Element element = (Element) dao.read(4);
        element.setName("Цезій");
        dao.update(element);
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Element.class);
        Element element = (Element) dao.read(4);
        dao.delete(element);
    }
}