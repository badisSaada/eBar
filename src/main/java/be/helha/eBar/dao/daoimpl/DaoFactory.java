package be.helha.eBar.dao.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoFactory {
    public static final DaoFactory INSTANCE = new DaoFactory();
    public static final String FICHIERCONFIG ="C:\\Users\\Lounis\\Desktop\\Fiche 1-20240207\\GradleJavaProject\\eBar3\\src\\test\\config.json";
    public static final Connection CON;

    static {
        try {
            CON = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public DaoFactory() {
    }

    public BiereDaoImpl getBiereDao() {
        return new BiereDaoImpl();
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }
    public Connection getConnection(){
        return CON;
    }
}


