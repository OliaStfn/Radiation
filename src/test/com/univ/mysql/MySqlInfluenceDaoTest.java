package com.univ.mysql;

public class MySqlInfluenceDaoTest {
   /* @Test
    public void create() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Radiation.class);
        Radiation radiation = (Radiation) dao.read(3);

        dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = new Influence();
        influence.setPercentageOfContamination(80);
        influence.setProbabilityOfMutation(9);
        influence.setRadiation(radiation);
        Influence getInfluence = (Influence) dao.create(influence);
        assertNotNull(getInfluence);
        System.out.println(getInfluence.toString());
    }

    @Test
    public void read() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence findInfluence = (Influence) dao.read(1);
        assertNotNull(findInfluence);
        System.out.println(findInfluence.toString());
    }

    @Test
    public void readAll() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        ArrayList<Influence> influences = dao.readAll();
        assertNotNull(influences);
    }

    @Test
    public void update() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = (Influence) dao.read(1);
        influence.setPercentageOfContamination(66);
        dao.update(influence);
    }

    @Test
    public void delete() throws Exception {
        MySqlDaoFactory factory = new MySqlDaoFactory();
        AbstractDao dao = factory.getDao(factory.getConnection(), Influence.class);
        Influence influence = (Influence) dao.read(2);
        dao.delete(influence);
    }*/
}