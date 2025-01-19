/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class TranslatorManager {
    
    private String currentLanguage;  // Idioma actualmente seleccionado
    private final Map <String,Translator> languages; // Mapa que asocia el nombre del idioma con su correspondiente Translator
   
    /**
     * Constructor del TranslatorManager.
     * Inicializa el idioma por defecto como "español" y configura los idiomas disponibles en el mapa.
     * 
     * @throws FileNotFoundException Si no se encuentra el archivo de traducción.
     * @throws IOException Si ocurre un error al leer los archivos de traducción.
     */
    public TranslatorManager() throws FileNotFoundException, IOException {
        currentLanguage = "spanish"; // Idioma por defecto (español)
        languages = new HashMap <> ();  // Mapa para almacenar los objetos Translator por idioma
        initializeTranslators();  // Inicializa los objetos Translator para los diferentes idiomas
    }

    /**
     * Inicializa los objetos Translator para los idiomas disponibles 
     * y los añade al mapa de idiomas.
     * 
     * @throws FileNotFoundException Si algún archivo de traducción no se encuentra.
     * @throws IOException Si ocurre un error al leer los archivos de traducción.
     */
    private void initializeTranslators() throws FileNotFoundException, IOException {
        // Crea un Translator para cada idioma y lo añade al mapa
        languages.put("spanish", new Translator("src\\Traductions\\spanish"));
        languages.put("english", new Translator("src\\Traductions\\english"));
        languages.put("catalan", new Translator("src\\Traductions\\catalan"));
        languages.put("portuguese", new Translator("src\\Traductions\\portuguese"));
    }

    /**
     * Cambia el idioma actual a uno de los idiomas disponibles.
     * 
     * @param languageSelected El idioma a seleccionar (por ejemplo, "ingles", "catalan", "portugues").
     */
    public void selectLanguage(String languageSelected)  {
        currentLanguage = languageSelected; // Actualiza el idioma seleccionado
    }
    
    /**
     * Traduce un texto al idioma actualmente seleccionado utilizando el objeto Translator correspondiente.
     * 
     * @param text El texto que se desea traducir.
     * @return La traducción del texto al idioma seleccionado.
     */
    public String translate(String text) {
        // Obtiene el Translator correspondiente al idioma seleccionado
        Translator translator = languages.get(currentLanguage);
        // Devuelve la traducción del texto utilizando el Translator seleccionado
        return translator.translate(text);
    }
}
