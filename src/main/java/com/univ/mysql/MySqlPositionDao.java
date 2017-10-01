package com.univ.mysql;

import com.univ.beans.Position;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlPositionDao extends AbstractDao<Position,Long> {
    public MySqlPositionDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM position WHERE position_id=?;";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM position;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE position SET latitude_degree=?,latitude_minute=?," +
                "longitude_degree=?,longitude_minute=? WHERE position_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO position(latitude_degree,latitude_minute," +
                "longitude_degree,longitude_minute) VALUES (?,?,?,?)";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM position WHERE position_id=?;";
    }

    @Override
    public ArrayList<Position> parsData(ResultSet rs) throws DaoException {
        ArrayList<Position> result = new ArrayList<>();
        try {
            while (rs.next()){
                Position temp = new Position();

                temp.setId(rs.getLong("position_id"));
                temp.setLatitudeDegree(rs.getInt("latitude_degree"));
                temp.setLatitudeMinute(rs.getInt("latitude_minute"));
                temp.setLongitudeDegree(rs.getInt("longitude_degree"));
                temp.setLongitudeMinute(rs.getInt("longitude_minute"));

                result.add(temp);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return result;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Position obj) throws DaoException {
        try {
            prSt.setInt(1,obj.getLatitudeDegree());
            prSt.setInt(2,obj.getLatitudeMinute());
            prSt.setInt(3,obj.getLongitudeDegree());
            prSt.setInt(4,obj.getLongitudeMinute());
            prSt.setLong(5,obj.getId());

        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Position obj) throws DaoException {
        try {
            prSt.setInt(1,obj.getLatitudeDegree());
            prSt.setInt(2,obj.getLatitudeMinute());
            prSt.setInt(3,obj.getLongitudeDegree());
            prSt.setInt(4,obj.getLongitudeMinute());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
