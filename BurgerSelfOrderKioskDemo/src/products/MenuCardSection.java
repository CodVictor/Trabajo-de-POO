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
public class MenuCardSection {
    private String sectionName;
    private String imageFileName;
    private List<IndividualProduct> productList;
    
    public MenuCardSection (String name, String imageFileName, List<IndividualProduct> products){
        this.sectionName = name;
        this.imageFileName = imageFileName;
        this.productList = products;
    }
    
    public IndividualProduct getProduct(int number){
        return this.productList.get(number);
    }
    public List<IndividualProduct> getProducts() {
        return this.productList;
    }
    
    public String getSectionName(){
        return this.sectionName;
    }
    public int getNumberOfProducts(){
        return this.productList.size();
    }
    public String getImageFileName(){
        return this.imageFileName;
    }
    
}
