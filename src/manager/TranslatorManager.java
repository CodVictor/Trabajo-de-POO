/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author victor
 */
public class TranslatorManager {
    private Translator currentDictionary;
    private Map<String, Translator> dictionaries;
    
    public TranslatorManager() {
        dictionaries = new HashMap<>();
    }

    public void loadLanguages(String folderPath) throws FileNotFoundException {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                String language = file.getName().replace(".txt", ""); // Obtener el idioma del nombre del archivo
                dictionaries.put(language, new Translator(file.getPath()));
            }
        }
    }

    public void setCurrentLanguage(String language) {
        if (dictionaries.containsKey(language)) {
            currentDictionary = dictionaries.get(language);
        } else {
            throw new IllegalArgumentException("Idioma no encontrado: " + language);
        }
    }

    public String translate(String key) {
        if (currentDictionary != null) {
            return currentDictionary.translate(key);
        }
        return key; // Devuelve la clave si no hay diccionario actual
    }
}
