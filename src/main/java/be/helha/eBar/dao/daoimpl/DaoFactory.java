package be.helha.persistance;

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

