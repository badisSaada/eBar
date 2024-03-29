
package be.helha;



import be.helha.eBar.biere.Biere;
import be.helha.eBar.bundle.Bundle;
import be.helha.eBar.dao.daoimpl.BiereDaoMockImpl;
import be.helha.eBar.usecase.usecaseimpl.GestionBiereImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Integration {
    private GestionBiereImpl gestionBieres;

    @BeforeEach
    void setUp() {
        BiereDaoMockImpl biereDao = new BiereDaoMockImpl();
        gestionBieres = new GestionBiereImpl(biereDao);
    }

    @Test
    void testAjouterBiere() throws SQLException {
        Bundle bundle = new Bundle();
        Biere biere = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        bundle.put(Bundle.BIERE, biere);
        gestionBieres.ajouterBiere(bundle);
        assertTrue((Boolean) bundle.get(Bundle.OPERATION_REUSSIE));
        assertEquals("Bière ajoutée avec succès.", bundle.get(Bundle.MESSAGE));
    }

    @Test
    void testRechercherBiere() throws SQLException {
        Bundle bundle = new Bundle();
        bundle.put(Bundle.BIERE, "Bierasse");
        gestionBieres.rechercherBiere(bundle);
        String biere = (String) bundle.get(Bundle.BIERE);
        assertEquals("Bierasse", biere);
    }

    @Test
    void testLister() throws SQLException {
        Bundle bundle = new Bundle();
        gestionBieres.lister(bundle);
        assertNotNull(bundle.get(Bundle.LISTE));
        assertEquals(0, ((Iterable<?>) bundle.get(Bundle.LISTE)).spliterator().getExactSizeIfKnown());
    }

    @Test
    void testSupprimerBiere() throws SQLException {
        Bundle bundle = new Bundle();
        Biere biere = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        bundle.put(Bundle.BIERE, biere);
        gestionBieres.ajouterBiere(bundle);

        bundle.vider();
        bundle.put(Bundle.BIERE, biere);
        gestionBieres.supprimerBiere(bundle);
        assertTrue((Boolean) bundle.get(Bundle.OPERATION_REUSSIE));
        assertEquals("Bière supprimée avec succès.", bundle.get(Bundle.MESSAGE));
    }

    @Test
    void testModifierBiere() throws SQLException {
        Bundle bundle = new Bundle();
        Biere biere = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        bundle.put(Bundle.BIERE, biere);
        gestionBieres.ajouterBiere(bundle);

        bundle.vider();
        Biere modifiedBiere = new Biere("Condorcet", "Rouge", "Pinouz", "Namur");
        bundle.put(Bundle.BIERE, modifiedBiere);
        gestionBieres.modifierBiere(bundle);
        assertTrue((Boolean) bundle.get(Bundle.OPERATION_REUSSIE));
        assertEquals("Bière modifiée avec succès.", bundle.get(Bundle.MESSAGE));
    }
}

