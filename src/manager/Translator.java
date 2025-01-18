/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//Esto esta todo en el Tema 7
/**
 *
 * @author victor
 */
public class Translator {
    private Map<String, String> words;

    public Translator(String fileName) throws FileNotFoundException {
        words = new HashMap<>();
        loadTraductions(fileName);
    }

    private void loadTraductions(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String original = scanner.nextLine().trim(); // Leer palabra original
            if (scanner.hasNextLine()) {
                String traduccion = scanner.nextLine().trim(); // Leer traducción
                words.put(original, traduccion);
            }
        }
        scanner.close();
    }

    public String translate(String key) {
        return words.getOrDefault(key, key); // Devuelve la traducción o la clave si no existe
    }
}
