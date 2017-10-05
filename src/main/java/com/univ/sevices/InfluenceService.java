package com.univ.sevices;

import com.univ.beans.Influence;
import com.univ.beans.Radiation;
import com.univ.beans.Recommendation;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;
import com.univ.dao.DaoFactory;
import com.univ.mysql.MySqlDaoFactory;

import java.time.LocalDate;
import java.util.HashSet;

public class InfluenceService implements IInfluenceService {
    @Override
    public Influence addInfluence(Influence influence) {
        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
            Radiation radiation = (Radiation) dao.create(influence.getRadiation());
            influence.setRadiation(radiation);

            dao = factory.getDao(factory.getConnection(), Influence.class);
            influence = (Influence) dao.create(radiation);
        } catch (DaoException e) {
            //TODO: log
        }
        return influence;
    }

    @Override
    public Radiation addRadiation(Radiation radiation) {
        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
            radiation = (Radiation) dao.create(radiation);
        } catch (DaoException e) {
            //TODO: log
        }
        return radiation;
    }

    @Override
    public void autoChangeInfluence() {
    }

    @Override
    public void changeInfluence(Influence influence) {
        DaoFactory factory = new MySqlDaoFactory();
        try {
            AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
            dao.update(influence);
        } catch (DaoException e) {
            //TODO: log
        }
    }

    @Override
    public Influence approximation(HashSet<Influence> nearPositions) {
        int percentageOfContamination = 0;
        double radiation = 0;
        String advantageType = "";
        for (Influence influence : nearPositions) {
            percentageOfContamination += influence.getPercentageOfContamination();
            Radiation temp = influence.getRadiation();
            radiation += temp.getRadiation();
            advantageType = temp.getAdvantageType();
        }
        percentageOfContamination /= nearPositions.size();
        radiation /= nearPositions.size();

        Radiation create = new Radiation();
        create.setRadiation(radiation);
        create.setAdvantageType(advantageType);
        create.setLastUpdateDate(LocalDate.now());

        Influence influence = new Influence();
        influence.setRadiation(addRadiation(create));
        influence.setPercentageOfContamination(percentageOfContamination);
        setMutation(influence);

        return addInfluence(influence);
    }

    @Override
    public void setMutation(Influence influence) {

    }

    @Override
    public Recommendation getRecommendation(Influence influence) {

        return null;
    }
}
