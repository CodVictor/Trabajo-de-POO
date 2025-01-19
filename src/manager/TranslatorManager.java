/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author victor
 */

public class TranslatorManager {
    private Translator currentTranslator;
    private Map<String, Translator> dictionaries;

    BufferedReader archivo;
    FileReader lector; 
    
    
    public TranslatorManager() {//constructor
        dictionaries = new HashMap<>();
        loadDictionaries();
    }

    private void loadDictionaries() {
        dictionaries.put("spanish", new Translator("Traductions/es.txt"));
        dictionaries.put("english", new Translator("Traductions/en.txt"));
        dictionaries.put("catalan", new Translator("Traductions/ca.txt"));
        dictionaries.put("portugues", new Translator("Traductions/pt.txt"));

    }

    
    public void setCurrentTranslator(String lang) {
        currentTranslator = dictionaries.get(lang);
    }

    public String translate(String string) {
        return currentTranslator != null ? currentTranslator.translate(string) : string;
    }

    public Map<String, Translator> getDictionaries() {
        return dictionaries;
    }
}

