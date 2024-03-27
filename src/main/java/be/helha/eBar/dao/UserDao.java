package be.helha.eBar.dao;

import be.helha.eBar.dao.daoimpl.Dao;
import be.helha.eBar.user.User;

import java.sql.SQLException;

public interface UserDao extends Dao {
	boolean ajouterUser(User user) throws SQLException;

	User getUser(String email, String password) throws SQLException;


}
