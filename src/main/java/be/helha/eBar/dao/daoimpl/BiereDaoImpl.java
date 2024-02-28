package be.helha.eBar.dao.daoimpl;

import be.helha.eBar.biere.Biere;
import be.helha.eBar.dao.BiereDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BiereDaoImpl implements BiereDao {
    public DaoFactory instance;

    public BiereDaoImpl() {
        this.instance = DaoFactory.getInstance();
        Comparator<String> comp = new ComparateurBieres();

    }


    @Override
    public boolean ajouterBiere(Biere biere) throws SQLException {
        if (biere == null) {
            return false; // Ne peut pas ajouter une bière null ou déjà existante
        }
        Connection con = this.instance.getConnection();
        Statement statement = con.createStatement();
        statement.executeUpdate("INSERT INTO bieres(nom, type, couleur,brasserie) VALUES ('Bierassse', 'Alcool', 'jaune','eBar')");
        return true;
    }

    @Override
    public Biere getBiere(String nom) {
        return mapBiere.get(nom); // Renvoie la bière correspondant au nom spécifié
    }

    @Override
    public List<Biere> listerBiere() {
        return new ArrayList<>(mapBiere.values()); // Renvoie une liste contenant toutes les bières
    }

    @Override
    public boolean modifierBiere(Biere biere) {
        if (biere == null || !mapBiere.containsKey(biere.getNom())) {
            return false; // Ne peut pas modifier une bière null ou inexistante
        }
        mapBiere.put(biere.getNom(), biere);
        return true;
    }

    @Override
    public boolean supprimerBiere(Biere biere) {
        if (biere == null || !mapBiere.containsKey(biere.getNom())) {
            return false; // Ne peut pas supprimer une bière null ou inexistante
        }
        mapBiere.remove(biere.getNom());
        return true;
    }

    private class ComparateurBieres implements Comparator<String> {
        @Override
        public int compare(String nom1, String nom2) {
            return nom1.compareTo(nom2);
        }
    }
}
