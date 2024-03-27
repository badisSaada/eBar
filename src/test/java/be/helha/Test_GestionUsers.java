package be.helha;

import be.helha.eBar.bundle.UserDTO;
import be.helha.eBar.usecase.GestionUsers;
import be.helha.eBar.usecase.usecaseimpl.GestionUsersImpl;
import be.helha.eBar.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests d'intégration du usecase GestionUsers
 * Ces tests supposent que la db contient 3 users (cf. script d'ajout)
 */
public class Test_GestionUsers {

	private static final String EMAIL_TOTO = "toto@gmail.com";
	private static final String NOM_TOTO = "Toto";
	private static final String PASSWORD_TOTO = "1234";
	private static final String AUTRE_PASSWORD = "****";
	private static final String EMAIL_TITI = "titi@gmail.com";
	private static final String EMAIL_TATA = "tata@gmail.com";
	private static final String NOM_TATA = "Tata";
	private static final String PASSWORD_TATA = "1234";

	private static GestionUsers gestionUsers;
	private static UserDTO userDTO;

	@BeforeAll
	static void initialisation() throws Exception {
		userDTO = new UserDTO();
		gestionUsers = new GestionUsersImpl();
	}

	@Test
	public void testConnecter1() {
		User user = new User(EMAIL_TOTO,PASSWORD_TOTO,NOM_TOTO);
		user.setEmail(EMAIL_TOTO);
		user.setPassword(PASSWORD_TOTO);
		userDTO.put(UserDTO.USER, user);
		gestionUsers.connecterUser(userDTO);
		assertTrue((Boolean) userDTO.get(UserDTO.OPERATION_REUSSIE));
		user = (User) userDTO.get(UserDTO.USER);
		assertNotNull(user);
		assertEquals(NOM_TOTO, user.getNom());
		assertEquals(EMAIL_TOTO, user.getEmail());
	}

	@Test
	public void testConnecter2() {
		User user = new User(EMAIL_TOTO,AUTRE_PASSWORD,NOM_TOTO);
		user.setEmail(EMAIL_TOTO);
		user.setPassword(AUTRE_PASSWORD);
		userDTO.put(UserDTO.USER, user);
		gestionUsers.connecterUser(userDTO);
		assertFalse((Boolean) userDTO.get(UserDTO.OPERATION_REUSSIE));
	}

	@Test
	public void testConnecter3() {
		User user = new User(EMAIL_TATA,PASSWORD_TATA,NOM_TATA);
		user.setEmail(EMAIL_TATA);
		user.setPassword(PASSWORD_TATA);
		userDTO.put(UserDTO.USER, user);
		gestionUsers.connecterUser(userDTO);
		assertTrue((Boolean) userDTO.get(UserDTO.OPERATION_REUSSIE));
		user = (User) userDTO.get(UserDTO.USER);
		assertNotNull(user);
		assertEquals(NOM_TATA, user.getNom());
		assertEquals(EMAIL_TATA, user.getEmail());
	}

	@Test
	public void testConnecter4() {
		User user = new User(EMAIL_TITI,PASSWORD_TOTO,NOM_TATA);
		user.setEmail(EMAIL_TITI);
		user.setPassword(PASSWORD_TOTO);
		userDTO.put(UserDTO.USER, user);
		gestionUsers.connecterUser(userDTO);
		assertFalse((Boolean) userDTO.get(UserDTO.OPERATION_REUSSIE));
	}

}