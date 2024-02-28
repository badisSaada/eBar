package be.helha.eBar.usecase;

import be.helha.eBar.*;
import be.helha.eBar.bundle.Bundle;

import java.sql.SQLException;

public interface GestionBiere {
    public void ajouterBiere(Bundle bundle) throws SQLException;
    public void lister(Bundle bundle) throws SQLException;
    public void modifierBiere(Bundle bundle) throws SQLException;
    public void rechercherBiere(Bundle bundle) throws SQLException;
    public void supprimerBiere(Bundle bundle) throws SQLException;
}
