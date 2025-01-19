/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manager;

import java.io.IOException;

/**
 *
 * @author Usuario
 */
public class BurgerKioskApplication {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        KioskManager kioskManager = new KioskManager();
        kioskManager.start();
    }
}
