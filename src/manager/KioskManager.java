package manager;
import screens.WellcomeScreen;

class KioskManager {
    
        Context context = new Context();
    public void start() {
            
                KioskScreen currentScreen = new WellcomeScreen(); // Pantalla inicial
        while(true) {
            currentScreen = currentScreen.show(context); // Muestra la pantalla actual y obtiene la próxima
        }    
    }
     
}  
