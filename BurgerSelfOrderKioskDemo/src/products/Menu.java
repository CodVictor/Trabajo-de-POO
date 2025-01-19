/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Menu implements Product{
    
    private int discount;
    private List<IndividualProduct> products;
    
    public Menu(List<IndividualProduct> products, int discount){
        this.products = products;
        this.discount = discount;
    }
    public float setDiscount(int discount){
        
    }

    @Override
    public int getPrice() {
        int total = products.stream().mapToInt(IndividualProduct::getPrice).sum();
        return total - (total * discount/100);
    }

    @Override
    public String getName() {
        return "Menu";
    }
    
    public IndividualProduct getProduct(int index){
        return products.get(index);
    }
    
    public int getNumberOfProducts(){
        return products.size();
    }
}
