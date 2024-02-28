package be.helha.eBar.dao;

import be.helha.eBar.biere.Biere;

import java.sql.SQLException;
import java.util.List;

public interface BiereDao {
    public boolean ajouterBiere(Biere biere) throws SQLException;
    public Biere getBiere(String nom) throws SQLException;
    public List<Biere> listerBiere() throws SQLException;
    public boolean modifierBiere(Biere biere) throws SQLException;
    public boolean supprimerBiere(Biere biere) throws SQLException;
}
