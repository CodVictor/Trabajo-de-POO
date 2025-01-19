/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.io.Serializable;
import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */
public class MenuCard implements Serializable {
    private List<MenuCardSection> sectionList;

    // Constructor
    public MenuCard(List<MenuCardSection> sectionList) {
        this.sectionList = sectionList;
    }
    
    // Método para obtener una sección por índice
    public MenuCardSection getSection(int index) {
        return this.sectionList.get(index);
    }
    public List<MenuCardSection> getSectionList(){
        return this.sectionList;
    }

    // Método para obtener el número de secciones
    public int getNumberOfSections() {
        return sectionList.size();  // Devuelve el tamaño de la lista
    }

    // Método estático para cargar el MenuCard desde el disco
    public static MenuCard loadFromDisk() {
         try {
            // Abrir el archivo XML
            FileInputStream fileInputStream = new FileInputStream("src\\KioskFiles\\Catalog.xml");

            // Usar XMLDecoder para deserializar el objeto
            XMLDecoder decoder = new XMLDecoder(fileInputStream);

            // Leer el objeto MenuCard desde el archivo
            MenuCard menuCard = (MenuCard) decoder.readObject();

            // Cerrar el XMLDecoder
            decoder.close();

            return menuCard;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


