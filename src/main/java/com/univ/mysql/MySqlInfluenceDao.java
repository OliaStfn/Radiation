package com.univ.mysql;

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
        return "SELECT * FROM influence inf LEFT JOIN radiation r " +
                "USING(radiation_id) WHERE influence_id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM influence inf LEFT JOIN radiation r USING(radiation_id);";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE influence SET probability_of_mutation=?, " +
                "percentage_of_contamination=? WHERE influence_id=?;";
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO influence (probability_of_mutation,percentage_of_contamination,radiation_id) " +
                "VALUES (?,?,?);";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM influence WHERE influence_id=?;";
    }

    @Override
    public ArrayList<Influence> parsData(ResultSet rs) throws DaoException {
        ArrayList<Influence> result = new ArrayList<>();

        try {
            while (rs.next()) {
                Influence temp = new Influence();
                Radiation radiation = new Radiation();

                radiation.setId(rs.getLong("radiation_id"));
                radiation.setRadiation(rs.getDouble("radiation"));
                radiation.setAdvantageType(rs.getString("radiation_advantage_type"));
                radiation.setLastUpdateDate(rs.getDate("last_update_date").toLocalDate());

                temp.setId(rs.getLong("influence_id"));
                temp.setProbabilityOfMutation(rs.getInt("probability_of_mutation"));
                temp.setPercentageOfContamination(rs.getInt("percentage_of_contamination"));
                temp.setRadiation(radiation);

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
            prSt.setInt(1, obj.getProbabilityOfMutation());
            prSt.setInt(2, obj.getPercentageOfContamination());
            prSt.setLong(3, obj.getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public void parsInsert(PreparedStatement prSt, Influence obj) throws DaoException {
        try {
            prSt.setInt(1, obj.getProbabilityOfMutation());
            prSt.setInt(2, obj.getPercentageOfContamination());
            prSt.setLong(3, obj.getRadiation().getId());
        } catch (SQLException e) {
            throw new DaoException();
        }
    }
}
