package com.univ.mysql;

import com.univ.beans.Influence;
import com.univ.beans.Place;
import com.univ.beans.Position;
import com.univ.beans.Radiation;
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
        return "SELECT * FROM place pl " +
                "LEFT JOIN influence inf USING(influence_id) " +
                "LEFT JOIN radiation r USING(radiation_id) " +
                "NATURAL JOIN position p ON(pl.position_id=p.position_id) " +
                "WHERE place_id=?;";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM place pl " +
                "LEFT JOIN influence inf USING(influence_id) " +
                "LEFT JOIN radiation r USING(radiation_id) " +
                "NATURAL JOIN position p ON(pl.position_id=p.position_id);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE place SET place_name=?,place_description=?,position_id=?,influence_id=?" +
                "WHERE place_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO place(place_name,place_description,position_id,influence_id) " +
                "VALUES(?,?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM place WHERE place_id=?;";
    }

    @Override
    public ArrayList<Place> parsData(ResultSet rs) throws DaoException {
        ArrayList<Place> result = new ArrayList<>();

        try {
            while (rs.next()) {
                Place temp = new Place();
                Position position = new Position();
                Influence influence = new Influence();
                Radiation radiation = new Radiation();

                radiation.setId(rs.getLong("radiation_id"));
                radiation.setRadiation(rs.getDouble("radiation"));
                radiation.setAdvantageType(rs.getString("radiation_advantage_type"));
                radiation.setLastUpdateDate(rs.getDate("last_update_date").toLocalDate());

                influence.setId(rs.getLong("influence_id"));
                influence.setProbabilityOfMutation(rs.getInt("probability_of_mutation"));
                influence.setPercentageOfContamination(rs.getInt("percentage_of_contamination"));
                influence.setRadiation(radiation);

                position.setId(rs.getLong("position_id"));
                position.setLatitudeDegree(rs.getInt("latitude_degree"));
                position.setLatitudeMinute(rs.getInt("latitude_minute"));
                position.setLongitudeDegree(rs.getInt("longitude_degree"));
                position.setLongitudeMinute(rs.getInt("longitude_minute"));

                temp.setId(rs.getLong("place_id"));
                temp.setName(rs.getString("place_name"));
                temp.setDescription(rs.getString("place_description"));
                temp.setInfluence(influence);
                temp.setPosition(position);

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
            prSt.setLong(3, obj.getPosition().getId());
            prSt.setLong(4, obj.getInfluence().getId());
            prSt.setLong(5, obj.getId());

        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Place obj) throws DaoException {
        try {
            prSt.setString(1, obj.getName());
            prSt.setString(2, obj.getDescription());
            prSt.setLong(3, obj.getPosition().getId());
            prSt.setLong(4, obj.getInfluence().getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
