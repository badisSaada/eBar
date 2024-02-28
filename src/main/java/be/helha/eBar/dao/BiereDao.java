package be.helha.eBar.dao;

import be.helha.eBar.biere.Biere;

import java.sql.SQLException;
import java.util.List;

public interface BiereDao {
    public boolean ajouterBiere(Biere biere) throws SQLException;
    public Biere getBiere(String nom);
    public List<Biere> listerBiere();
    public boolean modifierBiere(Biere biere);
    public boolean supprimerBiere(Biere biere);
}
