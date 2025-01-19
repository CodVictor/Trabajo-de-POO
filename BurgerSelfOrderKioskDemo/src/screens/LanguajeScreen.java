/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

import manager.Context;
import manager.SimpleKiosk;
import manager.KioskScreen;
import manager.TranslatorManager;

/**
 *
 * @author victor
 */
public class LanguajeScreen implements KioskScreen {

    @Override
    public KioskScreen show(Context context) {
          
            configureScreenButtons(context); //mete los botones en la pantalla
            
            SimpleKiosk kiosk = context.getKiosk(); //creamos kiosk
            TranslatorManager translator = context.getTranslator(); 
          
            //ahora el waitbutton espera a que el usuario pulse uno de los botones 
            char event = kiosk.waitPressButton(); //en SimpleKiosk hay un metodo public q tiene waitButton() {return waitevent(60);}
            
            
           KioskScreen nextScreen = this;
            
        switch (event) {
            case 'B':
                /*Si el usuario apreta el boton de español,
                automaticamente el traslatormanager realiza la traduccion*/
                translator.selectLanguage("spanish");
                configureScreenButtons(context); //mete los botones en la pantalla
                break;
            case 'C':
                translator.selectLanguage("english");
                configureScreenButtons(context); //mete los botones en la pantalla
                break;
            case 'D':
                translator.selectLanguage("catalan");
                configureScreenButtons(context); //mete los botones en la pantalla
                break;
            case 'E':
                translator.selectLanguage("portuguese");
                configureScreenButtons(context); //mete los botones en la pantalla
                 break;
            case 'F':
                nextScreen = new WellcomeScreen();
                break;
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
                kiosk.setDescription(manager.translate("Dispuestos a hacer la mejor hamburgesa del mundo"));
                
                kiosk.setOption('B', manager.translate("Español"));
                
                kiosk.setOption('C', manager.translate("Ingles"));
                
                kiosk.setOption('D', manager.translate("Catalan"));
                
                kiosk.setOption('E', manager.translate("Portugues"));
                
                kiosk.setOption('F', manager.translate("Volver"));
  
                
            }
    }