package be.helha.eBar.biere;

import java.util.Objects;

/**
 * Cette classe décrit les objets de type Biere.
 *
 * @see be.helha.eBar.biere
 */
public class Biere {
    /**
     * Brasserie de la bière.
     */
    private String brasserie;
    /**
     * Couleur de la bière.
     */
    private String couleur;
    /**
     * Nom de la bière.
     */
    private String nom;
    /**
     * Type de la bière.
     */
    private String type;

    /**
     * Constructeur de la classe Biere.
     *
     * @param brasserie Brasserie de la bière.
     * @param couleur   Couleur de la bière.
     * @param nom       Nom de la bière.
     * @param type      Type de la bière.
     */
    public Biere(String brasserie, String couleur, String nom, String type) {
        this.brasserie = brasserie;
        this.couleur = couleur;
        this.nom = nom;
        this.type = type;
    }

    /**
     * Constructeur de la classe Biere à partir d'une bière existante.
     *
     * @param biere Bière de base.
     */
    public Biere(Biere biere) {
        this(biere.brasserie, biere.couleur, biere.nom, biere.type);
    }

    /**
     * Méthode comparant deux bières sur leurs noms.
     *
     * @param biere Bière à comparer.
     * @return true si les noms des bières sont égaux, false sinon.
     */
    public boolean equals(Biere biere) {
        return Objects.equals(this.nom, biere.nom);
    }

    /**
     * Méthode renvoyant la brasserie de la bière.
     *
     * @return La brasserie de la bière.
     */
    public String getBrasserie() {
        return brasserie;
    }

    /**
     * Méthode renvoyant la couleur de la bière.
     *
     * @return La couleur de la bière.
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Méthode renvoyant le nom de la bière.
     *
     * @return Le nom de la bière.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode renvoyant le type de la bière.
     *
     * @return Le type de la bière.
     */
    public String getType() {
        return type;
    }

    /**
     * Modifie la brasserie de la bière.
     *
     * @param brasserie La nouvelle brasserie de la bière.
     */
    public void setBrasserie(String brasserie) {
        this.brasserie = brasserie;
    }

    /**
     * Modifie la couleur de la bière.
     *
     * @param couleur La nouvelle couleur de la bière.
     */
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    /**
     * Modifie le nom de la bière.
     *
     * @param nom Le nouveau nom de la bière.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifie le type de la bière.
     *
     * @param type Le nouveau type de la bière.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Méthode permettant d'obtenir une représentation sous forme de chaîne de caractères de l'objet Biere.
     *
     * @return La représentation sous forme de chaîne de caractères de l'objet Biere.
     */
    @Override
    public String toString() {
        return "Biere{" +
                "brasserie='" + brasserie + '\'' +
                ", couleur='" + couleur + '\'' +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

