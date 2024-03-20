package be.helha;


import be.helha.eBar.dao.daoimpl.ParserConfig;
import be.helha.eBar.dao.daoimpl.Persistance;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Test_Parser {

    @Test
    void testParserMockConfig() {
        String fileName = "C:\\Users\\Lounis\\Desktop\\Fiche 1-20240207\\GradleJavaProject\\eBar3\\src\\test\\config2.json";
        try {
            Persistance persistance = ParserConfig.lireConfiguration(fileName);
            assertNotNull(persistance);
            assertEquals("MOCK", persistance.getType());
            assertNull(persistance.getUrl());
            assertNull(persistance.getUser());
            assertNull(persistance.getPassword());
        } catch (IOException | IllegalArgumentException e) {
            fail("Une exception a été levée : " + e.getMessage());
        }
    }
    @Test
    void testParserDBConfig() {
        String fileName = "C:\\Users\\Lounis\\Desktop\\Fiche 1-20240207\\GradleJavaProject\\eBar3\\src\\test\\config.json";
        try {
            Persistance persistance = ParserConfig.lireConfiguration(fileName);
            assertNotNull(persistance);
            assertEquals("DB", persistance.getType());
            assertNotNull(persistance.getUrl());
            assertNotNull(persistance.getUser());
            assertNotNull(persistance.getPassword());
        } catch (IOException | IllegalArgumentException e) {
            fail("Une exception a été levée : " + e.getMessage());
        }
    }
    @Test
    void testParserMySQLConfig() {
        String fileName = "C:\\Users\\Lounis\\Desktop\\Fiche 1-20240207\\GradleJavaProject\\eBar3\\src\\test\\config.json";
        try {
            Persistance persistance = ParserConfig.lireConfiguration(fileName);
            assertNotNull(persistance);
            assertEquals("DB", persistance.getType());
            assertEquals("jdbc:postgresql://localhost:5432/postgres", persistance.getUrl());
            assertEquals("postgres", persistance.getUser());
            assertEquals("1234", persistance.getPassword());
        } catch (IOException | IllegalArgumentException e) {
            fail("Une exception a été levée : " + e.getMessage());
        }
    }


}

