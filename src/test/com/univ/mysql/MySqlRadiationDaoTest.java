package com.univ.mysql;

import com.univ.beans.Radiation;
import com.univ.dao.AbstractDao;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MySqlRadiationDaoTest {
    @Test
    public void create() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
        Radiation radiation = new Radiation();
        radiation.setRadiation(0.8);
        radiation.setAdvantageType("цезій");

        radiation.setLastUpdateDate(LocalDate.now());
        Radiation getRadiation = (Radiation) dao.create(radiation);
        assertNotNull(getRadiation);
        System.out.println(getRadiation.toString());
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
        Radiation findRadiation = (Radiation) dao.read(2);
        assertNotNull(findRadiation);
        System.out.println(findRadiation.toString());
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
        ArrayList<Radiation> radiations = dao.readAll();
        assertNotNull(radiations);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
        Radiation radiation = (Radiation) dao.read(2);
        radiation.setRadiation(0.5);
        dao.update(radiation);
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
        Radiation radiation = (Radiation) dao.read(2);
        dao.delete(radiation);
    }

}