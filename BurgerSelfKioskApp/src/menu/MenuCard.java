/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.util.List;

public class MenuCard {
    private List<MenuCardSection> sectionList;

    public static MenuCard loadFromDisk() {
        // Carga los datos desde un archivo
        return new MenuCard();
    }

    public MenuCardSection getSection(int index) {
        return sectionList.get(index);
    }

    public int getNumberOfSections() {
        return sectionList.size();
    }
}

