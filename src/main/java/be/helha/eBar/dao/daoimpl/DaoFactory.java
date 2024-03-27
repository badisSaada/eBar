package be.helha.eBar.dao.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class DaoFactory {
    public static final DaoFactory INSTANCE = new DaoFactory();
    public static final String FICHIERCONFIG = "C:\\Users\\Lounis\\Desktop\\Fiche 1-20240207\\GradleJavaProject\\eBar3\\src\\test\\config.json";
    public static final Connection CON;
    private static final Map<String, String> daoImplMap = new HashMap<>();

    static {
        // Initialisation de la collection avec les associations entre les interfaces et les implémentations
        daoImplMap.put("be.helha.eBar.dao.UserDao", "be.helha.eBar.dao.daoimpl.UserDaoImpl");
        // Ajoutez d'autres associations ici si nécessaire
    }

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

    public Connection getConnection() {
        return CON;
    }

    public static Dao getDaoImpl(Class<? extends Dao> interfaceDao) throws Exception {
        String nomInterfaceDao = interfaceDao.getName();


        // Vérifiez si le mapping existe pour l'interface spécifiée
        if (daoImplMap.containsKey(nomInterfaceDao)) {
            String nomDaoImpl = daoImplMap.get(nomInterfaceDao);
            Class<?> classeDaoImpl = Class.forName(nomDaoImpl);

            // Vérifiez si l'interface spécifiée est assignable à la classe d'implémentation
            if (interfaceDao.isAssignableFrom(classeDaoImpl)) {
                // Créez une instance de la classe d'implémentation correspondante et renvoyez-la
                return (Dao) classeDaoImpl.getDeclaredConstructor().newInstance();
            } else throw new IllegalArgumentException("Interface dao non prise en charge2 : " + nomInterfaceDao);
        }

        throw new IllegalArgumentException("Interface dao non prise en charge : " + nomInterfaceDao);
    }

}




