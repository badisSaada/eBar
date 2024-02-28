package be.helha;

import be.helha.eBar.biere.Biere;
import be.helha.eBar.dao.daoimpl.BiereDaoImpl;
import org.junit.jupiter.api.*;


import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests_BiereDaoImpl {

    private BiereDaoImpl biereDao;

    @BeforeEach
    void setUp() {
        biereDao = new BiereDaoImpl();
    }

    @Test
    @Order(1)
    void testAjouterBiere() throws SQLException {
        Biere biere = new Biere("Helha", "rouge", "Bierasse", "Louvain-la-Neuve");
        assertTrue(biereDao.ajouterBiere(biere));
    }

    @Test
    @Order(2)
    void testGetBiere() throws SQLException {
        Biere biere = new Biere("Helha", "rouge", "Bierasse", "Louvain-la-Neuve");
        Biere biereRecu = biereDao.getBiere("Bierasse");
        assertEquals(biere.getNom(), biereRecu.getNom());
    }

    @Test
    @Order(3)
    void testListerBiere() throws SQLException {
        List<Biere> listeBieres = biereDao.listerBiere();
        assertEquals(2, listeBieres.size());
    }

    @Test
    @Order(4)
    void testModifierBiere() throws SQLException {
        Biere modifiedBiere = new Biere("salut", "Rouge", "Bierasse", "Namur");
        assertTrue(biereDao.modifierBiere(modifiedBiere));
        assertEquals(modifiedBiere.getNom(), biereDao.getBiere("Bierasse").getNom());
    }

    @Test
    @Order(5)
    void testSupprimerBiere() throws SQLException {
        Biere biere = new Biere("salut", "Rouge", "Bierasse", "Namur");
        assertTrue(biereDao.supprimerBiere(biere));
        assertNull(biereDao.getBiere("Bierasse").getNom());
    }
}


