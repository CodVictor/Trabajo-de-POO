/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import java.io.*;
import java.util.List;
import java.util.Scanner;
import products.IndividualProduct;
import products.Order;
import products.MenuCard;
import products.MenuCardSection;

/**
 *
 * @author username
 */

public class Context {
    private SimpleKiosk kiosk;
    private TranslatorManager translator = new TranslatorManager();
    private Order order = new Order(5);
    private MenuCard menuCard;
    public int orderNumber;         // Al inicializar el programa, el número de orden es 0
    private int kioskNumber;        // Identifica cada pantalla (cada kiosco en la hamburguesería)
    private int numberOfKiosks;     // Número total de kioscos
    
    // Constructor
    public Context() throws IOException {
        
        //Cargamos los traductores creando un TranslatorManager
        this.translator = new TranslatorManager();
        
        //Creamos un SimpleKiosk
        this.kiosk = new SimpleKiosk(this.translator); // Pasar el traductor al kiosco
       
        //cargamos la carta de menú:
        this.menuCard = MenuCard.loadFromDisk(); // Cargar la carta del menú


        // Leer configuración del archivo KioskConfiguration.txt
        String configFileName = "src\\KioskFiles\\KioskConfiguration.txt";
        try (InputStream stream = new FileInputStream(configFileName);
             Scanner scanner = new Scanner(stream)) {
            if (scanner.hasNextLine()) {
                this.kioskNumber = Integer.parseInt(scanner.nextLine().trim()); // Número de kiosco
            }
            if (scanner.hasNextLine()) {
                this.numberOfKiosks = Integer.parseInt(scanner.nextLine().trim()); // Número total de kioscos
            }
            System.out.println("Configuración cargada: Kiosco #" + kioskNumber + ", Total kioscos: " + numberOfKiosks);
        } catch (FileNotFoundException e) {
            System.err.println("Archivo de configuración no encontrado: " + configFileName);
        } catch (NumberFormatException e) {
            System.err.println("Formato incorrecto en el archivo de configuracion.");
        }

        // Verificar o inicializar el archivo ActualOrder.txt
        String orderFileName = "src\\KioskFiles\\ActualOrder.txt";
        File orderFile = new File(orderFileName);
        if (!orderFile.exists() || orderFile.length() == 0) {
            // Si el archivo no existe o está vacío, inicializar con el valor 1
            try (Writer writer = new FileWriter(orderFile)) {
                writer.write("1");
                this.orderNumber = 1;
                System.out.println("Número de pedido inicializado a 1.");
            } catch (IOException e) {
                System.err.println("Error al crear o escribir en ActualOrder.txt: " + e.getMessage());
            }
        } else {
            // Leer el número de pedido actual
            try (InputStream orderStream = new FileInputStream(orderFile);
                 Scanner orderScanner = new Scanner(orderStream)) {
                if (orderScanner.hasNextLine()) {
                    this.orderNumber = Integer.parseInt(orderScanner.nextLine().trim());
                    System.out.println("Número de pedido actual: " + this.orderNumber);
                } else {
                    System.err.println("ActualOrder.txt está vacío. Se inicializará el número de pedido a 1.");
                    this.orderNumber = 1;
                }
            } catch (IOException | NumberFormatException e) {
                System.err.println("Error al leer ActualOrder.txt: " + e.getMessage());
                this.orderNumber = 1;
            }
        }
    }
    
    // Getters
    public TranslatorManager getTranslator() {
        return translator; // Obtiene el translator que tenga el idioma elegido
    }

    public SimpleKiosk getKiosk() {
        return kiosk;
    }

    public Order getOrder() {
        return order;
    }

    public MenuCard getMenuCard() {
        return menuCard;
    }

    // Setter para la orden
    public void setOrder(Order order) {
        this.order = order;
    }

    // Métodos relacionados con el kiosco
    public int getOrderNumber() {
        return orderNumber;
    }

    public int getKioskNumber() {
        return kioskNumber;
    }

    public int getNumberOfKiosks() {
        return numberOfKiosks;
    }

    public void resetOrder() {
        this.order = null;
    }
}

