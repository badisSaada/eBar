package be.helha.persistance;
import be.helha.metier.Biere;


import java.util.*;

public class BiereDaoMockImpl implements BiereDao {
    private Map<String, Biere> mapBiere;

    public BiereDaoMockImpl() {
        Comparator<String> comp = new ComparateurBieres();
        this.mapBiere = new TreeMap<>(comp);
    }

    @Override
    public boolean ajouterBiere(Biere biere) {
        if (biere == null || mapBiere.containsKey(biere.getNom())) {
            return false; // Ne peut pas ajouter une bière null ou déjà existante
        }
        mapBiere.put(biere.getNom(), biere);
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

