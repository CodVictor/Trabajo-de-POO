/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author Usuario
 */
public class Translator {
    private Map <String,String> palabras;
    
    public Translator (String fileName){
        this.palabras = new HashMap<>();
    }
    public String translate(String string){
        return this.palabras.get(string);
    }

}
