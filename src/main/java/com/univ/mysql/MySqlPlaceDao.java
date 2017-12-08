package com.univ.mysql;

import com.univ.beans.Element;
import com.univ.beans.Influence;
import com.univ.beans.Place;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlPlaceDao extends AbstractDao<Place, Long> {
    public MySqlPlaceDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM Places p LEFT JOIN Influences inf ON(p.Influences_influence_id=inf.influence_id) " +
                "LEFT JOIN Elements e ON(inf.Elements_element_id=e.element_id) WHERE place_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM Places p LEFT JOIN Influences inf ON(p.Influences_influence_id=inf.influence_id) " +
                "LEFT JOIN Elements e ON(inf.Elements_element_id=e.element_id);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Places SET name=?,description=?,latitude=?,longitude=?,Influences_influence_id=? " +
                "WHERE place_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO Places(name,description,latitude,longitude,Influences_influence_id) " +
                "VALUES(?,?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM Places WHERE place_id=?;";
    }

    @Override
    public ArrayList<Place> parsData(ResultSet rs) throws DaoException {
        ArrayList<Place> result = new ArrayList<>();

        try {
            while (rs.next()) {
                Place temp = new Place();
                Influence influence = new Influence();
                Element element = new Element();

                element.setId(rs.getLong("element_id"));
                element.setRadioactiveElement(rs.getString("radioactive_element"));
                element.setName(rs.getString("element_name"));
                element.setNumber(rs.getInt("number"));
                element.setMass(rs.getInt("mass"));

                influence.setId(rs.getLong("influence_id"));
                influence.setRadiation(rs.getDouble("radiation"));
                influence.setElement(element);
                influence.setLastUpdateTime(rs.getTimestamp("last_update_time").toLocalDateTime());

                temp.setId(rs.getInt("place_id"));
                temp.setName(rs.getString("name"));
                temp.setDescription(rs.getString("description"));
                temp.setLatitude(rs.getString("latitude"));
                temp.setLongitude(rs.getString("longitude"));
                temp.setInfluence(influence);

                result.add(temp);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return result;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Place obj) throws DaoException {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getDescription());
            prSt.setString(3, obj.getLatitude());
            prSt.setString(4, obj.getLongitude());
            prSt.setLong(5, obj.getInfluence().getId());
            prSt.setLong(6, obj.getId());

        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Place obj) throws DaoException {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getDescription());
            prSt.setString(3, obj.getLatitude());
            prSt.setString(4, obj.getLongitude());
            prSt.setLong(5, obj.getInfluence().getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
