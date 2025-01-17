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
    private Translator currentDictionary;
    final private Map<String,Translator> dictionaries;
    
    public TranslatorManager(Translator currentDictionary, Map<String,Translator> dictionaries){
        this.currentDictionary = currentDictionary;
        this.dictionaries = new HashMap<>();
    }
    public void setCurrentIdiom(String idiom){
        this.currentDictionary = dictionaries.get(idiom);
    }
    public List<String> getIdioms(){
        return new ArrayList<>(this.dictionaries.keySet());
    }
    public String translate (String string){
        return this.currentDictionary.translate(string);
    }
}
