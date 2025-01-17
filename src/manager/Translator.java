/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.util.Map;
import java.util.HashMap;
import java.io.*; //para poder llamar a IOException, BufferedReader y FileReader
//Esto esta todo en el Tema 7
/**
 *
 * @author victor
 */
public class Translator{
    private Map<String, String> words; 
    
   fileName = 'Traductions/'+languaje+'.txt';
        // Método para cargar las traducciones desde un archivo
    private void loadTraductions( String fileName) throws IOException { //si hay algun problema el metodo puede lanzar una excepcion
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine())!= null ){
                String[] parts = line.split("=");
                if (parts.length == 2) { 
                    words.put(parts[0].trim(), parts[1].trim());
                }
            }
        }
    }
    'Traductions/'+languaje+'.txt'; //recoge la ruta del fichero de traducciones
    /*Explicacion BORRAR ANTES DE ENTREGA
    BufferedReader-> lee el texto de english.txt y catalan.txt linea por linea
    
    FileReader->Especifica el archivo a leer
    
    try -> Asegura que BufferedReader se cierre automáticamente al final, 
    incluso si ocurre una excepción.
    
    reader.readLine()-> Lee una línea completa del archivo. Si no hay más líneas, devuelve null.
    
    while-> Se ejecuta mientras haya líneas en el archivo.
    
    linea.split("="): Divide la línea en dos partes usando el carácter = como separador.
    
    El resultado es un arreglo (partes) con dos elementos:
        partes[0]: La clave (por ejemplo, "Nuevo pedido").
        partes[1]: El valor (por ejemplo, "New order").
    
    partes[0].trim(): Elimina espacios al inicio y final de la clave.
    partes[1].trim(): Elimina espacios al inicio y final del valor.
    palabras.put(): Guarda la clave y el valor en el mapa palabras
    */
   
    public Translator(String fileName) throws IOException{
        words = new HashMap<>();
        loadTraductions(fileName); 
    }
    public String translate(String word){
        //devuelve la palabra NO traducida en caso 
        //de que no tenga traduccion
        return words.getOrDefault(word, word); 
        
    }
    
}
