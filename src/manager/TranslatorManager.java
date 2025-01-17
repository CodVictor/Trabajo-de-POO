/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.util.*;
/**
 *
 * @author victor
 */
public class TranslatorManager {
    private Translator currentDictionary;
    private Map<String, Translator> dictionaries;

    // Constructor que inicializa los diccionarios
    public TranslatorManager() {
        dictionaries = new HashMap<>();
    }

    // Método para establecer el idioma actual
    public void setCurrentLanguaje(String languaje) {
        currentDictionary = dictionaries.get(languaje);
    }

    // Método para obtener la lista de idiomas disponibles
    public List<String> getLanguajes() {
        return new ArrayList<>(dictionaries.keySet());
    }

    // Método para traducir una cadena
    public String translate(String word) {
        if (currentDictionary == null) {
            return word; // Si no hay diccionario activo, devuelve la palabra original
        }
        return currentDictionary.translate(word);
    }
}
