/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.util.List;

public class MenuCardSection {
    private String sectionName;
    private List<IndividualProduct> productList;

    public String getSectionName() {
        return sectionName;
    }

    public IndividualProduct getProduct(int index) {
        return productList.get(index);
    }

    public int getNumberOfProducts() {
        return productList.size();
    }
}
