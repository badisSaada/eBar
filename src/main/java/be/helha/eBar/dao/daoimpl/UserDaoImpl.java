package be.helha.eBar.dao.daoimpl;

import be.helha.eBar.dao.UserDao;
import be.helha.eBar.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private DaoFactory instance;

    public UserDaoImpl() {
        this.instance = DaoFactory.getInstance();
    }

    // Méthode pour libérer les ressources JDBC
    public static void cloturer(ResultSet res, PreparedStatement stm, Connection con) throws SQLException {
        res.close();
        stm.close();
        con.close();
    }

    @Override
    public boolean ajouterUser(User user) throws SQLException {
        if (user == null) {
            return false; // Ne peut pas ajouter un utilisateur null
        }
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO users(nom, email) VALUES (?, ?)");
        pstmt.setString(1, user.getNom());
        pstmt.setString(2, user.getEmail());
        pstmt.executeUpdate();
        return true;
    }

    @Override
    public User getUser(String email, String password) throws SQLException {
        if (email == null || password == null) {
            throw new IllegalArgumentException("L'email et le mot de passe ne peuvent pas être null");
        }
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email=? and password = crypt(?, password)");
        pstmt.setString(1, email);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        User user = null;
        while (rs.next()) {
            String nom = rs.getString("nom");
            String userEmail = rs.getString("email");
            // Pas besoin de vérifier le mot de passe ici car la requête SQL a déjà fait cela
            user = new User(userEmail,"",nom );
        }
        cloturer(rs, pstmt, con);
        return user;
    }




    public List<User> listerUsers() throws SQLException {
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users");
        ResultSet rs = pstmt.executeQuery();
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            String nom = rs.getString("nom");
            String email = rs.getString("email");
            User user = new User(nom,"",email);
            userList.add(user);
        }
        cloturer(rs, pstmt, con);
        return userList;
    }


    public boolean modifierUser(User user) throws SQLException {
        if (user == null) {
            return false; // Ne peut pas modifier un utilisateur null
        }
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("UPDATE users SET nom = ? WHERE email = ?");
        pstmt.setString(1, user.getNom());
        pstmt.setString(2, user.getEmail());
        pstmt.executeUpdate();
        return true;
    }


    public boolean supprimerUser(User user) throws SQLException {
        if (user == null) {
            return false; // Ne peut pas supprimer un utilisateur null
        }
        Connection con = this.instance.getConnection();
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM users WHERE email = ?");
        pstmt.setString(1, user.getEmail());
        pstmt.executeUpdate();
        return true;
    }
}

