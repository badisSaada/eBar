package be.helha.eBar.bundle;

import java.util.HashMap;
import java.util.Map;

/**
 * Une instance de cette classe contient des données liées à un utilisateur (UserDTO).
 * Elle facilite le transfert de ces données entre différentes couches de l'application.
 */
public class UserDTO {
    /**
     * Constantes pour les clés utilisées dans le UserDTO.
     */
    public static final String MESSAGE = "message";
    public static final String USER = "user";
    public static final String OPERATION_REUSSIE = "operationReussie";
    public static final String LISTE = "liste";
    public static final String NOM = "nom";

    private Map<String, Object> map = new HashMap<>();

    /**
     * Constructeur par défaut de la classe UserDTO. Initialise certaines valeurs par défaut.
     */
    public UserDTO() {
        this.map.put(UserDTO.OPERATION_REUSSIE, true);
        this.map.put(UserDTO.MESSAGE, "");
    }

    /**
     * Ajoute une entrée à la map du UserDTO.
     *
     * @param clef   La clé de l'objet dans la map.
     * @param valeur La valeur de l'objet dans la map.
     */
    public void put(String clef, Object valeur) {
        this.map.put(clef, valeur);
    }

    /**
     * Récupère la valeur associée à une clé dans la map du UserDTO.
     *
     * @param clef La clé de l'objet dans la map.
     * @return La valeur associée à la clé spécifiée, ou null si la clé n'existe pas dans la map.
     */
    public Object get(String clef) {
        return this.map.get(clef);
    }

    /**
     * Vide la map du UserDTO.
     */
    public void vider() {
        this.map.clear();
    }
}
