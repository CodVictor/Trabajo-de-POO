package manager;
import screens.WellcomeScreen;

class KioskManager {
    
        Context context = new Context();
        
    public void start() {
                    while(true) {
            KioskScreen currentScreen = new WellcomeScreen(); // Pantalla inicial
            currentScreen = currentScreen.show(context); // Muestra la pantalla actual y obtiene la próxima
        }    
    }
     
}  
