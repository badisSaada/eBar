package be.helha.eBar.dao;

import be.helha.eBar.biere.Biere;

import java.util.List;

public interface BiereDao {
    public boolean ajouterBiere(Biere biere);
    public Biere getBiere(String nom);
    public List<Biere> listerBiere();
    public boolean modifierBiere(Biere biere);
    public boolean supprimerBiere(Biere biere);
}
