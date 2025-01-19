/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.io.*;
import java.util.*;
//Esto esta todo en el Tema 7
/**
 *
 * @author victor
 */
public class Translator {
    private Map<String, String> translations;

    public Translator(String filename) {
        translations = new HashMap<>();
        loadTranslations(filename);
    }

    private void loadTranslations(String filename) {
        //leemos el archivo txt con BufferedReader 
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
            String line;
            String spanishWord = null;
            
            while ((line = reader.readLine()) != null) {//si el resultado es distinto de null quiere decir que hay algo 
                
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