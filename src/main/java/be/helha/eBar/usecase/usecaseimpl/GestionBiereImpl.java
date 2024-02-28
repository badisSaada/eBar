package be.helha.eBar.usecase.usecaseimpl;

import be.helha.eBar.biere.Biere;
import be.helha.eBar.bundle.Bundle;
import be.helha.eBar.dao.BiereDao;
import be.helha.eBar.usecase.GestionBiere;

import java.sql.SQLException;


public class GestionBiereImpl implements GestionBiere {
    private BiereDao biereDao;

    // Constructeur prenant en paramètre l'instance de BiereDao
    public GestionBiereImpl(BiereDao biereDao) {
        this.biereDao = biereDao;
    }

    @Override
    public void ajouterBiere(Bundle bundle) throws SQLException {
        if (bundle.get(Bundle.BIERE) instanceof Biere) {
            Biere biere = (Biere) bundle.get(Bundle.BIERE);
            boolean ajout = biereDao.ajouterBiere(biere);
            bundle.put(Bundle.OPERATION_REUSSIE, ajout);
            if (ajout) {
                bundle.put(Bundle.MESSAGE, "Bière ajoutée avec succès.");
            } else {
                bundle.put(Bundle.MESSAGE, "Erreur lors de l'ajout de la bière.");
            }
        } else {
            bundle.put(Bundle.OPERATION_REUSSIE, false);
            bundle.put(Bundle.MESSAGE, "Bundle ne contient pas d'objet biere.");
        }
    }

    @Override
    public void lister(Bundle bundle) throws SQLException {
        bundle.put(Bundle.LISTE, biereDao.listerBiere());
    }

    @Override
    public void modifierBiere(Bundle bundle) throws SQLException {
        if (bundle.get(Bundle.BIERE) instanceof Biere) {
            Biere biere = (Biere) bundle.get(Bundle.BIERE);
            boolean modification = biereDao.modifierBiere(biere);
            bundle.put(Bundle.OPERATION_REUSSIE, modification);
            if (modification) {
                bundle.put(Bundle.MESSAGE, "Bière modifiée avec succès.");
            } else {
                bundle.put(Bundle.MESSAGE, "Erreur lors de la modification de la bière.");
            }
        } else {
            bundle.put(Bundle.OPERATION_REUSSIE, false);
            bundle.put(Bundle.MESSAGE, "Bundle ne contient pas d'objet biere.");
        }
    }

    @Override
    public void rechercherBiere(Bundle bundle) throws SQLException {
        if (bundle.get(Bundle.NOM) instanceof String) {
            String nom = (String) bundle.get(Bundle.NOM);
            Biere biere = biereDao.getBiere(nom);
            if (biere != null) {
                bundle.put(Bundle.BIERE, biere);
            } else {
                bundle.put(Bundle.BIERE, null);
                bundle.put(Bundle.MESSAGE, "Aucune bière trouvée avec le nom : " + nom);
            }
        } else {
            bundle.put(Bundle.OPERATION_REUSSIE, false);
            bundle.put(Bundle.MESSAGE, "Bundle ne contient pas de clé 'nom' pour rechercher la bière.");
        }
    }

    @Override
    public void supprimerBiere(Bundle bundle) throws SQLException {
        if (bundle.get(Bundle.BIERE) instanceof Biere) {
            Biere biere = (Biere) bundle.get(Bundle.BIERE);
            boolean suppression = biereDao.supprimerBiere(biere);
            bundle.put(Bundle.OPERATION_REUSSIE, suppression);
            if (suppression) {
                bundle.put(Bundle.MESSAGE, "Bière supprimée avec succès.");
            } else {
                bundle.put(Bundle.MESSAGE, "Erreur lors de la suppression de la bière.");
            }
        } else {
            bundle.put(Bundle.OPERATION_REUSSIE, false);
            bundle.put(Bundle.MESSAGE, "Bundle ne contient pas d'objet biere.");
        }
    }
}

