/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

/**
 *
 * @author Usuario
 */
public class IndividualProduct {
    
    private String name;
    private String description;
    private String imageFileName;
    private int price;
    
    public IndividualProduct (String name, String description, String imageFileName, int price){
        this.name = name;
        this.description = description;
        this.imageFileName = imageFileName;
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getImageFileName(){
        return this.imageFileName;
    }
}
