/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

/**
 *
 * @author victor
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Menu implements Product {
    private String name; // Nombre del menú
    private int discount; // Descuento aplicado al menú en porcentaje
    private List<IndividualProduct> products; // Lista de productos incluidos en el menú

    // Constructor
    public Menu(String name, int discount) {
        this.name = name;
        this.discount = discount;
        this.products = new ArrayList<>();
    }

    // Añadir un producto al menú
    public void addProduct(IndividualProduct product) {
        products.add(product);
    }

    // Obtener el precio total del menú (aplicando descuento)
    @Override
    public int getPrice() {
        int totalPrice = 0;
        for (IndividualProduct product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice - (totalPrice * discount / 100);
    }

    // Obtener un producto específico por índice
    public IndividualProduct getProduct(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    // Obtener el número de productos en el menú
    public int getNumProducts() {
        return products.size();
    }

    // Obtener el nombre del menú
    @Override
    public String getName() {
        return name;
    }

    // Escribir los datos del menú en un archivo
    public void saveToFile(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Menu: " + name + "\n");
            writer.write("Descuento: " + discount + "%\n");
            writer.write("Productos:\n");
            for (IndividualProduct product : products) {
                writer.write("- " + product.getName() + " (" + product.getPrice() + " céntimos)\n");
            }
            writer.write("Precio total: " + getPrice() + " céntimos\n");
        }
    }

    // Leer los datos del menú desde un archivo
    public static Menu loadFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String nameLine = reader.readLine(); // Leer la línea del nombre
            String discountLine = reader.readLine(); // Leer la línea del descuento

            // Extraer datos del archivo
            String name = nameLine.split(": ")[1];
            int discount = Integer.parseInt(discountLine.split(": ")[1].replace("%", ""));

            // Crear un nuevo menú
            Menu menu = new Menu(name, discount);

            // Leer los productos
            reader.readLine(); // Saltar la línea "Productos:"
            String productLine;
            while ((productLine = reader.readLine()) != null) {
                if (productLine.startsWith("Precio total:")) {
                    break;
                }
                String[] parts = productLine.split(" \\(");
                String productName = parts[0].substring(2); // Quitar "- "
                int productPrice = Integer.parseInt(parts[1].replace(" céntimos)", ""));
                menu.addProduct(new IndividualProduct(productName, productPrice));
            }

            return menu;
        }
    }

    @Override
    public String getImagePath() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
