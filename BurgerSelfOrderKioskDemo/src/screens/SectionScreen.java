/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;

/**
 *
 * @author victor
 */
class SectionScreen implements KioskScreen {
  @Override
    public KioskScreen show(Context context) {
        SimpleKiosk kiosk = context.getKiosk();
        MenuCard menuCard = context.getMenuCard();

        kiosk.clearScreen();
        kiosk.setTitle("Seleccione una sección");

        for (int i = 0; i < menuCard.getNumberOfSections(); i++) {
            MenuCardSection section = menuCard.getSection(i);
            kiosk.setOption((char) ('A' + i), section.getSectionName());
        }

        char event = kiosk.waitEvent(30);
        int sectionIndex = event - 'A';
        if (sectionIndex >= 0 && sectionIndex < menuCard.getNumberOfSections()) {
            return new ProductScreen(sectionIndex);
        }
        return null;
    }
}