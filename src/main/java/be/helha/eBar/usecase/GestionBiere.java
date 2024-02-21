package be.helha.eBar.usecase;

import be.helha.metier.Bundle;

public interface GestionBiere {
    public void ajouterBiere(Bundle bundle);
    public void lister(Bundle bundle);
    public void modifierBiere(Bundle bundle);
    public void rechercherBiere(Bundle bundle);
    public void supprimerBiere(Bundle bundle);
}
