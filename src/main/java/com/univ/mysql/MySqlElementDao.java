package com.univ.mysql;

import com.univ.beans.Element;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlElementDao extends AbstractDao<Element, Long> {
    public MySqlElementDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Elements WHERE element_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM Elements;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Elements SET radioactive_element=?, element_name=?, number=?, mass=? WHERE element_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Elements (radioactive_element, element_name, number, mass) VALUES(?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Elements WHERE element_id=?;";
    }

    @Override
    public ArrayList<Element> parsData(ResultSet rs) throws DaoException {
        ArrayList<Element> result = new ArrayList<>();

        try {
            while (rs.next()) {
                Element temp = new Element();

                temp.setId(rs.getLong("element_id"));
                temp.setRadioactiveElement(rs.getString("radioactive_element"));
                temp.setName(rs.getString("element_name"));
                temp.setNumber(rs.getInt("number"));
                temp.setMass(rs.getInt("mass"));

                result.add(temp);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return result;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Element obj) throws DaoException {
        try {
            prSt.setString(1, obj.getRadioactiveElement());
            prSt.setString(2, obj.getName());
            prSt.setInt(3, obj.getNumber());
            prSt.setInt(4, obj.getMass());
            prSt.setLong(5, obj.getId());

        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Element obj) throws DaoException {
        try {
            prSt.setString(1, obj.getRadioactiveElement());
            prSt.setString(2, obj.getName());
            prSt.setInt(3, obj.getNumber());
            prSt.setInt(4, obj.getMass());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
