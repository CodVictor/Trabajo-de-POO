/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class TranslatorManager {
     private Translator currentTranslator;
    private Map<String, Translator> dictionaries;

    public TranslatorManager() {
        dictionaries = new HashMap<>();
        dictionaries.put("spanish", new Translator("src\\Traductions\\spanish.txt"));
        dictionaries.put("english", new Translator("src\\Traductions\\english.txt"));
        dictionaries.put("catalan", new Translator("src\\Traductions\\catalan.txt"));
    }

    public void setCurrentTranslator(String lang) {
        currentTranslator = dictionaries.get(lang);
    }

    public String translate(String string) {
        return currentTranslator != null ? currentTranslator.translate(string) : string;
    }

    public List<String> getDictionaries() {
        List<String> dictionariesNames = new ArrayList<>(dictionaries.keySet());
        return dictionariesNames;
    }
}
