/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.util.List;


/**
 *
 * @author victor
 */
public class MenuCardSection {
    private List<IndividualProduct> items; //la seccion del menu es una lista de productos individuales
    private final String name;
    private final String imageFileName;
    
    //Construtor
    public MenuCardSection(String name, String imageFileName, List<IndividualProduct> prods) {
        this.name = name;
        this.imageFileName = imageFileName;
        this.items = items;
    }

    //getters
    public List<IndividualProduct> getItems() {
        return items;
    }
    public String getName() {
        return name;
    }
    public String getImageFileName() {
        return imageFileName;
    }
    
}