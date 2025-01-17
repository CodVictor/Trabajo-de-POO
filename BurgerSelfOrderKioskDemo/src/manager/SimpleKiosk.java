/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import sienens.BurgerSelfOrderKiosk;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class SimpleKiosk {
    final private BurgerSelfOrderKiosk kiosk;
    final private TranslatorManager translatorManager;
    
    public SimpleKiosk(TranslatorManager translatorManager){
        this.kiosk = new BurgerSelfOrderKiosk();
        this.translatorManager = translatorManager;
    }
    public void setOption (char option, String message){
        String translatedMessage = translatorManager.translate(message);
        this.kiosk.setOption(option,translatedMessage);
    }
    public void setTitle (String stringTitle){
        String translatedTitle = translatorManager.translate(stringTitle);
        this.kiosk.setTitle(translatedTitle);
    }
    public void setDescription (String stringDescription){
        String translatedDescription = translatorManager.translate(stringDescription);
        kiosk.setDescription(translatedDescription);
    }
    public void setMenuMode (){
        kiosk.setMenuMode();
    }   
    public char waitEvent (int seconds){
        return kiosk.waitEvent(seconds);
    }    
    public void print (String stringToPrint){
        String translatedString = translatorManager.translate(stringToPrint);
        List<String> translatedList = new ArrayList<>();
        translatedList.add(translatedString);
        this.kiosk.print(translatedList);     
    }
    public void retainCard (boolean bool){
        this.kiosk.retainCreditCard(bool);
    }
    public void expelCreditCard (int integer){
        this.kiosk.expelCreditCard(integer);
    }
//    public void clearScreen (){
//        this.kiosk.clearScreen();
//    }
    public void setImage (String stringImage){
        this.kiosk.setImage(stringImage);
    }
    public long getCardNumber (){
        return this.kiosk.getCardNumber();
    }
    public void setMessageMode(){
        this.kiosk.setMessageMode();
    }
}
