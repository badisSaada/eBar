package be.helha;

import be.helha.eBar.biere.Biere;
import be.helha.eBar.dao.BiereDao;
import be.helha.eBar.bundle.*;
import be.helha.eBar.dao.daoimpl.BiereDaoMockImpl;
import be.helha.eBar.usecase.*;
import org.junit.jupiter.api.*;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests_BiereDaoMockImpl {

    private BiereDaoMockImpl biereDao;

    @BeforeEach
    void setUp() {
        biereDao = new BiereDaoMockImpl();
    }

    @Test
    @Order(1)
    void testAjouterBiere() {
        Biere biere = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        assertTrue(biereDao.ajouterBiere(biere));
    }

    @Test
    @Order(2)
    void testGetBiere() {
        Biere biere = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        biereDao.ajouterBiere(biere);
        Biere biereRecu = biereDao.getBiere("Bierasse");
        assertEquals(biere, biereRecu);
    }

    @Test
    @Order(3)
    void testListerBiere() {
        Biere biere1 = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        Biere biere2 = new Biere("Condorcet", "Rouge", "Pinouz", "Namur");
        biereDao.ajouterBiere(biere1);
        biereDao.ajouterBiere(biere2);
        List<Biere> listeBieres = biereDao.listerBiere();
        assertEquals(2, listeBieres.size());
    }

    @Test
    @Order(4)
    void testModifierBiere() {
        Biere biere = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        biereDao.ajouterBiere(biere);
        Biere modifiedBiere = new Biere("Condorcet", "Rouge", "Bierasse", "Namur");
        assertTrue(biereDao.modifierBiere(modifiedBiere));
        assertEquals(modifiedBiere, biereDao.getBiere("Bierasse"));
    }

    @Test
    @Order(5)
    void testSupprimerBiere() {
        Biere biere = new Biere("Helha", "Bleu", "Bierasse", "Louvain-la-Neuve");
        biereDao.ajouterBiere(biere);
        assertTrue(biereDao.supprimerBiere(biere));
        assertNull(biereDao.getBiere("Bierasse"));
    }
}


