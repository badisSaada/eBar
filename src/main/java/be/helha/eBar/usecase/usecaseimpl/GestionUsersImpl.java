package be.helha.eBar.usecase.usecaseimpl;

import be.helha.eBar.bundle.Bundle;
import be.helha.eBar.bundle.UserDTO;
import be.helha.eBar.dao.UserDao;
import be.helha.eBar.dao.daoimpl.DaoFactory;
import be.helha.eBar.usecase.GestionUsers;
import be.helha.eBar.user.User;

import java.sql.SQLException;

public class GestionUsersImpl implements GestionUsers {

	private UserDao userDao;

	public GestionUsersImpl() throws Exception {
		this.userDao = (UserDao) DaoFactory.getInstance().getDaoImpl(UserDao.class);
	}

	@Override
	public void connecterUser(UserDTO bundle) {
		// Récupérer l'utilisateur du bundle
		User user = (User) bundle.get(Bundle.USER);

		try {
			// Demander au dao de fournir un utilisateur correspondant en base de données
			User userDB = this.userDao.getUser(user.getEmail(), user.getPassword());

			// Vérifier si l'utilisateur a été trouvé en base de données
			if (userDB != null) {
				// L'utilisateur a été identifié avec succès
				// Ajouter l'utilisateur identifié au bundle
				bundle.put(Bundle.NOM, userDB);
				// Ajouter un booléen signalant le succès de l'opération au bundle
				bundle.put(Bundle.OPERATION_REUSSIE, true);
				// Ajouter un message indiquant que l'utilisateur a été connecté avec succès
				bundle.put(Bundle.MESSAGE, "L'utilisateur a été connecté avec succès.");
			} else {
				// L'utilisateur n'a pas été trouvé en base de données
				// Ajouter un booléen indiquant que l'opération a échoué au bundle
				bundle.put(Bundle.OPERATION_REUSSIE, false);
				// Ajouter un message indiquant que l'email et/ou le mot de passe sont incorrects
				bundle.put(Bundle.MESSAGE, "L'email et/ou le mot de passe sont incorrects.");
			}
		} catch (SQLException e) {
			// En cas d'erreur lors de la communication avec la base de données
			// Ajouter un booléen indiquant que l'opération a échoué au bundle
			bundle.put(Bundle.OPERATION_REUSSIE, false);
			// Ajouter un message d'erreur au bundle
			bundle.put(Bundle.MESSAGE, "Une erreur est survenue lors de la connexion de l'utilisateur.");
			// Vous pouvez également journaliser l'erreur pour un suivi ultérieur
			e.printStackTrace();
		}
	}

}
