package manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import screens.WellcomeScreen;
/**
 *
 * @author victor
 */
public class KioskManager {
    private Context context;
    
    public KioskManager() throws FileNotFoundException, IOException{
            // Inicialización de context
            context = new Context();
    }
  public void start() {
            KioskScreen currentScreen = new WellcomeScreen(); // Pantalla inicial
        while (true) {
            currentScreen = currentScreen.show(context); // Muestra la pantalla actual y obtiene la próxima
        }
    }
}  
