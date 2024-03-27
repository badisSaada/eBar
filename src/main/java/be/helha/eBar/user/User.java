package be.helha.eBar.user;

public class User {
	private String email; // identifiant unique
	private String nom;
	private String password;
	
	public User(String email,String pswd,String nom) {
		super();
		this.email = email;
		this.nom=nom;
		this.password = pswd;
	}



	@Override
	public String toString() {
		return "User [email=" + email + ", nom=" + nom + ", motDePasse="
				+ password + "]";
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
