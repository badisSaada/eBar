package be.helha.eBar.bundle;

import java.util.HashMap;
import java.util.Map;

/**
 * classe décrivant un bundle classique
 *
 *
 */
public class Bundle {
	/**
	 * Constantes pour les clés utilisées dans le bundle.
	 */
	public static final String MESSAGE = "message";
	public static final String BIERE = "biere";
	public static final String OPERATION_REUSSIE = "operationReussie";
	public static final String LISTE = "liste";
	public static final String NOM = "nom";
	public static final String USER = "user";

	private Map<String, Object> map = new HashMap<>();

	/**
	 * Constructeur par défaut de la classe Bundle. Initialise certaines valeurs par défaut.
	 */
	public Bundle() {
		this.map.put(Bundle.OPERATION_REUSSIE, true);
		this.map.put(Bundle.MESSAGE, "");
	}

	/**
	 * Ajoute une entrée à la map du bundle.
	 *
	 * @param clef   La clé de l'objet dans la map.
	 * @param valeur La valeur de l'objet dans la map.
	 */
	public void put(String clef, Object valeur) {
		this.map.put(clef, valeur);
	}

	/**
	 * Récupère la valeur associée à une clé dans la map du bundle.
	 *
	 * @param clef La clé de l'objet dans la map.
	 * @return La valeur associée à la clé spécifiée, ou null si la clé n'existe pas dans la map.
	 */
	public Object get(String clef) {
		return this.map.get(clef);
	}

	/**
	 * Vide la map du bundle.
	 */
	public void vider() {
		this.map.clear();
	}
}

