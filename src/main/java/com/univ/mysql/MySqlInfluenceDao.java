package com.univ.mysql;

import com.univ.beans.Element;
import com.univ.beans.Influence;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlInfluenceDao extends AbstractDao<Influence, Long> {
    public MySqlInfluenceDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Influences inf LEFT JOIN Elements e " +
                "ON(inf.Elements_element_id=e.element_id) WHERE influence_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM Influences inf LEFT JOIN Elements e " +
                "ON(inf.Elements_element_id=e.element_id);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Influences SET radiation=?, " +
                "Elements_element_id=?, last_update_time=NOW() WHERE influence_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Influences (radiation, Elements_element_id, last_update_time) " +
                "VALUES (?,?,NOW());";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Influences WHERE influence_id=?;";
    }

    @Override
    public ArrayList<Influence> parsData(ResultSet rs) throws DaoException {
        ArrayList<Influence> result = new ArrayList<>();

        try {
            while (rs.next()) {
                Influence temp = new Influence();
                Element element = new Element();

                element.setId(rs.getLong("element_id"));
                element.setRadioactiveElement(rs.getString("radioactive_element"));
                element.setName(rs.getString("element_name"));
                element.setNumber(rs.getInt("number"));
                element.setMass(rs.getInt("mass"));

                temp.setId(rs.getLong("influence_id"));
                temp.setRadiation(rs.getDouble("radiation"));
                temp.setElement(element);
                temp.setLastUpdateTime(rs.getTimestamp("last_update_time").toLocalDateTime());

                result.add(temp);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return result;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Influence obj) throws DaoException {
        try {
            prSt.setDouble(1, obj.getRadiation());
            prSt.setLong(2, obj.getElement().getId());
            prSt.setLong(3, obj.getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Influence obj) throws DaoException {
        try {
            prSt.setDouble(1, obj.getRadiation());
            prSt.setLong(2, obj.getElement().getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
