/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import context.Context;
import screens.KioskScreen;
import screens.WellcomeScreen;

public class KioskManager {
    private Context context;
    private KioskScreen currentScreen;

    public void start() {
        context = new Context();
        context.initialize();

        currentScreen = new WellcomeScreen();
        while (currentScreen != null) {
            currentScreen = currentScreen.show(context);
        }
    }
}
