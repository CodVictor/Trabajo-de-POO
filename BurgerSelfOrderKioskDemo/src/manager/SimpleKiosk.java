/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.IOException;
import sienens.BurgerSelfOrderKiosk;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class SimpleKiosk {
    
    private final BurgerSelfOrderKiosk kiosk;    
    TranslatorManager translator;
           
    public SimpleKiosk(TranslatorManager translatorManager){
        this.kiosk = new BurgerSelfOrderKiosk();     
        this.translator = translatorManager;
    }

    public void clearScreen(){
        this.setTitle((String)null);
        this.setImage((String)null);
        this.setDescription((String)null);

    for (char cont = 'A'; cont <= 'H'; cont++)
        this.setOption(cont, (String)null);
    }

    //metodo que espera a que el usuario pulse un boton, si pasado un minuto no lo pulsa
    //el programa vuelve a wellcomeScreen 
    public char waitPressButton(){  
        return kiosk.waitEvent(60);
    }


    public char waitToInCard(){
        return kiosk.waitEvent(60);
    }


    public void setOption(char character, String option){
        kiosk.setOption(character, option);
    }

    public void setTitle(String title){
        kiosk.setTitle(title);
    }

    public void setDescription(String description){
        kiosk.setDescription(description);
    }

    public void setMenuMode(){//muestra una pantalla grande para poner un mensaje en grande (a, en enunciado)
        kiosk.setMenuMode();
    }

    public void setMessageMode(){ //muestra una pantalla grande para poner un mensaje en grande (b, en enunciado) 
        kiosk.setMessageMode();
    }


    public void print(List<String> print){
       kiosk.print(print);
    }

    public void retainCreditCard(boolean retain){
        kiosk.retainCreditCard(retain);
    }

    public TranslatorManager getTranslatorManager() throws IOException{
        TranslatorManager TranslatorManager = new TranslatorManager(); 
        return TranslatorManager;
    }

    public void expelCreditCard(int card){
        kiosk.expelCreditCard(card);
    }


    public void setImage(String imageFilePath){
        kiosk.setImage(imageFilePath);
    }

    public long getCardNumber(){
        kiosk.getCardNumber();
    return 0;
    }
 
}//End. 

