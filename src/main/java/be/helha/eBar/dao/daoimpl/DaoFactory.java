package be.helha.eBar.dao.daoimpl;

import be.helha.eBar.dao.daoimpl.BiereDaoMockImpl;

public class DaoFactory {
    public static final DaoFactory INSTANCE = new DaoFactory();

    public DaoFactory() {
    }

    public BiereDaoMockImpl getBiereDao() {
        return new BiereDaoMockImpl();
    }

    public static DaoFactory getInstance() {
        return INSTANCE;
    }
}

