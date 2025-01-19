/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Usuario
 */
public class Translator {
    private Map<String, String> translations;

    public Translator(String filename) {
        translations = new HashMap<>();
        loadTranslations(filename);
    }

    private void loadTranslations(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String spanishWord = null;
            while ((line = reader.readLine()) != null) {
                if (spanishWord == null) {
                    spanishWord = line.trim();
                } else {
                    translations.put(spanishWord, line.trim());
                    spanishWord = null; // reset for next word
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String translate(String word) {
        return translations.getOrDefault(word, word); // Si no encuentra la traducción, devuelve la palabra original
    }
}
