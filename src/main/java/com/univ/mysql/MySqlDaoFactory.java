package com.univ.mysql;

import com.univ.beans.Element;
import com.univ.beans.Influence;
import com.univ.beans.Place;
import com.univ.dao.AbstractDao;
import com.univ.dao.DaoException;
import com.univ.dao.DaoFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory<Connection> {

    private static final Logger log = Logger.getLogger(MySqlDaoFactory.class);
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/radiation?useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private Map<Class, DaoCreator> allDao;

    @Override
    public Connection getConnection() throws DaoException {
        Connection connection = null;
        try {
            Class.forName(driverName); // Завантажуємо клас драйвера
        } catch (ClassNotFoundException e) {
            log.error("Driver JDBC has NOT get");
            log.error(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("The successful connection for DB");
        } catch (SQLException e) {
            log.error("Failed connection for DB");
            log.error(e.getMessage());
        }
        return connection;
    }

    @Override
    public AbstractDao getDao(Connection connection, Class daoClass) throws DaoException {
        DaoCreator creator = allDao.get(daoClass);
        if (creator == null) {
            throw new DaoException("DAO for class " + daoClass + " not found");
        }
        return creator.create(connection);
    }


    public MySqlDaoFactory() {
        allDao = new HashMap<Class, DaoCreator>() {
        };
        allDao.put(Element.class, new DaoCreator() {
            @Override
            public AbstractDao create(Object connection) {
                return new MySqlElementDao((Connection) connection);
            }
        });
        allDao.put(Place.class, new DaoCreator() {
            @Override
            public AbstractDao create(Object connection) {
                return new MySqlPlaceDao((Connection) connection);
            }
        });

        allDao.put(Influence.class, new DaoCreator() {
            @Override
            public AbstractDao create(Object connection) {
                return new MySqlInfluenceDao((Connection) connection);
            }
        });
    }
}