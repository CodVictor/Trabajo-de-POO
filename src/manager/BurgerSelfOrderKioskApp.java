package manager;

import java.io.IOException;

/**
 *
 * @author jvelez
 */
//AQUI NO SE MODIFICA "NADA"!
public class BurgerSelfOrderKioskApp { //al inicio de la aplicación se crea el KioskManager
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        KioskManager atm = new KioskManager();
        atm.start();
    }
}
