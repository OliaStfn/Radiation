package com.univ.mysql;

import com.univ.beans.Radiation;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlRadiationDao extends AbstractDao<Radiation, Long> {
    public MySqlRadiationDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM radiation WHERE radiation_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM radiation;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE radiation SET radiation=?,radiation_advantage_type=?," +
                "last_update_date=CURDATE() WHERE radiation_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO radiation (radiation,radiation_advantage_type,last_update_date) " +
                "VALUES(?,?,CURDATE());";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM radiation WHERE radiation_id=?;";
    }

    @Override
    public ArrayList<Radiation> parsData(ResultSet rs) throws DaoException {
        ArrayList<Radiation> result = new ArrayList<>();
        try {
            while (rs.next()){
                Radiation temp = new Radiation();

                temp.setId(rs.getLong("radiation_id"));
                temp.setRadiation(rs.getDouble("radiation"));
                temp.setAdvantageType(rs.getString("radiation_advantage_type"));
                temp.setLastUpdateDate(rs.getDate("last_update_date").toLocalDate());

                result.add(temp);
            }
        } catch (SQLException e) {
            throw new DaoException();
        }
        return result;
    }

    @Override
    public void parsUpdate(PreparedStatement prSt, Radiation obj) throws DaoException {
        try {
            prSt.setDouble(1,obj.getRadiation());
            prSt.setString(2,obj.getAdvantageType());
            prSt.setLong(3,obj.getId());

        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Radiation obj) throws DaoException {
        try {
            prSt.setDouble(1,obj.getRadiation());
            prSt.setString(2,obj.getAdvantageType());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
