package be.helha.eBar.dao.daoimpl;



public class Persistance {
    private static final String DB = "DB";
    private static final String MOCK = "MOCK";
    private String type;
    private String dao;
    private String url;
    private String user;
    private String password;

    // Getters and setters
    public String getType() {
        return type;
    }



    public String getUrl() {
        return url;
    }



    public String getUser() {
        return user;
    }



    public String getPassword() {
        return password;
    }
    public String getDaoImpl() {
        return dao;
    }

    public Persistance(String type, String dao, String url, String user, String password) {
        this.type = type;
        this.dao = dao;
        this.url = url;
        this.user = user;
        this.password = password;
    }
}

