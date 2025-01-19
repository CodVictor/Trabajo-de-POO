/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;
import manager.KioskScreen;
import manager.Translator;
import manager.TranslatorManager;

/**
 *
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */ 
public class LanguajeScreen implements KioskScreen {

    @Override
    public KioskScreen show(Context context) {
          
            configureScreenButtons(context); //mete los botones en la pantalla
            
            SimpleKiosk kiosk = context.getKiosk(); //creamos kiosk
            TranslatorManager traslation = new TranslatorManager(); 
            
            //ahora el waitbutton espera a que el usuario pulse uno de los botones 
            char event = kiosk.waitPressButton(); //en SimpleKiosk hay un metodo public q tiene waitButton() {return waitevent(60);}
            
            
           KioskScreen nextScreen = this;
            
            if (event == 'B') {
                /*Si el usuario apreta el boton de español, 
                automaticamente el traslatormanager realiza la traduccion*/
                    traslation.setCurrentTranslator("es"); 
                    
            }else if ( event == 'C'){
                    traslation.setCurrentTranslator("en"); //ingles

            }else if ( event == 'D'){
                    traslation.setCurrentTranslator("ca"); //catalan
            }else if (event == 'E') {
                    traslation.setCurrentTranslator("pt"); //portugues
            }else if (event == 'F'){
                nextScreen = new WellcomeScreen();
            }
           
            
            return nextScreen; //no se vuelve a wellcome. Vuelve a esta misma pagina. 
         
     }//end of show
            
    private void configureScreenButtons(Context context) {
                TranslatorManager manager = context.getTranslator();
                SimpleKiosk kiosk = context.getKiosk();
                
                kiosk.clearScreen();
                kiosk.setMenuMode();
                kiosk.setTitle(manager.translate("Selecciona un idioma"));
                kiosk.setImage("idiomas.png");
                kiosk.setDescription(manager.translate("Escoge el idioma que desees"));
                
                kiosk.setOption('B', manager.translate("Español"));      
           
                kiosk.setOption('C', manager.translate("Ingles"));
                
                kiosk.setOption('D', manager.translate("Catalan"));
                
                kiosk.setOption('E', manager.translate("Portugues"));
                
                kiosk.setOption('F', manager.translate("Volver"));
  
                
            }
    }
