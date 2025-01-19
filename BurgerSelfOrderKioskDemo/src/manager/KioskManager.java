/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.*;
import screens.WellcomeScreen;


class KioskManager {
    private Context context;

    public void start() throws IOException {
        this.context = new Context();
        //Creamos la pantalla de bienvenida y le decimos que muestre el contexto:
        WellcomeScreen ws = new WellcomeScreen();
        KioskScreen nextScreen = ws.show(context);

        while (true){
            nextScreen = nextScreen.show(context);
        }
    }
}
