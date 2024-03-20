package be.helha.eBar.dao.daoimpl;


import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParserConfig {
    public ParserConfig() {
    }

    public static Persistance lireConfiguration(String fileName) throws IOException, IllegalArgumentException {
        Gson gson = new Gson();
        Persistance persistance;
        Path path = Paths.get(fileName);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            persistance = gson.fromJson(reader, Persistance.class);
        } catch (IOException e) {
            throw new IOException("Erreur lors de la lecture du fichier de configuration : " + e.getMessage());
        }

        // Vérification des valeurs lues
        if (persistance.getType() == null || (!persistance.getType().equals("MOCK") && !persistance.getType().equals("DB"))) {
            throw new IllegalArgumentException("Le type de système de persistance spécifié dans le fichier de configuration est inconnu ou absent.");
        }

        if (persistance.getType().equals("MOCK")) {
            // Pour le type MOCK, seul le type est obligatoire
            if (persistance.getUrl() != null || persistance.getUser() != null || persistance.getPassword() != null) {
                throw new IllegalArgumentException("Pour le type de persistance MOCK, seul le type est nécessaire.");
            }
        } else if (persistance.getType().equals("DB")) {
            // Pour le type DB, les attributs url, login et password sont obligatoires
            if (persistance.getUrl() == null || persistance.getUser() == null || persistance.getPassword() == null) {
                throw new IllegalArgumentException("Pour le type de persistance DB, les attributs url, login et password sont obligatoires.");
            }
        }

        return persistance;
    }
}

