package be.helha.eBar.biere;

import java.util.Objects;

public class Biere {
    private String brasserie;
    private String couleur;
    private String nom;
    private String type;

    public Biere(String brasserie, String couleur, String nom, String type) {
        this.brasserie = brasserie;
        this.couleur = couleur;
        this.nom = nom;
        this.type = type;
    }
    public Biere(Biere biere){
        new Biere(biere.brasserie,biere.couleur,biere.nom,biere.type);
    }
    public boolean equals(Biere biere){
        return Objects.equals(this.nom, biere.nom);
    }
    public String getBrasserie() {
        return brasserie;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public void setBrasserie(String brasserie) {
        this.brasserie = brasserie;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

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
