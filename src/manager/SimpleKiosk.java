/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.List;
import sienens.BurgerSelfOrderKiosk;

/**
 *
 * @author victor
 */
public class SimpleKiosk {
    
    private final BurgerSelfOrderKiosk kiosk = new BurgerSelfOrderKiosk();    
    TranslatorManager translator = new TranslatorManager();
    
        public void clearScreen(){
            setTitle(null);
            setImage(null);
            setDescription(null);
       
        for (char cont = 'A'; cont <= 'H'; cont++)
            setOption(cont, null);
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
        
       
        public SimpleKiosk(){
            SimpleKiosk SimpleKiosk = new SimpleKiosk();
        }

    
 
}//End. 
