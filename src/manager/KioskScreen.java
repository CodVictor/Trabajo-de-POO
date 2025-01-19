
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

/**
 *
 * @author victor
 */
//NO MODIFICAR "NADA" AQUI.
public interface KioskScreen { //prototipo de pantalla. 
    /**
     * Muestra la pantalla actual y devuelve la próxima pantalla a mostrar.
     *
     * @param context El contexto que contiene el estado compartido entre pantallas.
     * @return La próxima pantalla que se debe mostrar.
     */
    public KioskScreen show(Context context);
    
}

    
    

