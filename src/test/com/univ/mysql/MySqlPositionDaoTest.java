package com.univ.mysql;

import com.univ.beans.Position;
import com.univ.dao.AbstractDao;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MySqlPositionDaoTest {
    @Test
    public void create() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Position.class);
        Position position = new Position();
        position.setLatitudeDegree(16);
        position.setLatitudeMinute(5);
        position.setLongitudeDegree(32);
        position.setLongitudeMinute(26);

        Position getPosition = (Position) dao.create(position);
        assertNotNull(getPosition);
        System.out.println(getPosition.toString());
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Position.class);
        Position findPosition = (Position) dao.read(1);
        assertNotNull(findPosition);
        System.out.println(findPosition.toString());
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Position.class);
        ArrayList<Position> positions = dao.readAll();
        assertNotNull(positions);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Position.class);
        Position position = (Position) dao.read(1);
        position.setLongitudeMinute(44);
        dao.update(position);
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Position.class);
        Position position = (Position) dao.read(2);
        dao.delete(position);
    }

}