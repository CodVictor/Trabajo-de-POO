/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import screens.*;
import manager.*;
import java.util.*;

public class KioskManager { 
 
    public void start() {
        //Traductores
        Translator espanyolIngles = new Translator("español-ingles");
        Translator espanyolChino = new Translator("español-chino");
        //Mapa con distintos traductores
        Map<String,Translator> dictionaries = new HashMap<>();
        dictionaries.put("espanyolIngles",espanyolIngles);
        dictionaries.put("espanyolChino",espanyolChino);
        //Manejador de traductores
        TranslatorManager translatorManager = new TranslatorManager(espanyolIngles,dictionaries);
        
        SimpleKiosk simpleKiosk = new SimpleKiosk(translatorManager);
        Context context = new Context();
//        KioskScreen kioskScreen = new KioskScreen();      
    }
}
