/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package screens;


import java.util.List;
import products.Product;
/**
 *
 * @author Victor Oliveira, Ruben Ruiz, Ariel Lozano
 */                             
public class CarrouselScreen {
    
    private List<Product> products; // lista de productos a mostrar en el carrusel
    private int currentIndex; // indice del producto actual en el carrusel
    
    // constructor de la clase, recibe una lista de productos y la inicializa
    public CarrouselScreen(List<Product> products) {
        this.products = products; 
        this.currentIndex = 0; // empieza con el primer producto (indice 0)
    }

    // metodo para obtener el producto actual que se esta mostrando en el carrusel
    public Product getCurrentProduct() {
        return products.get(currentIndex); // devuelve el producto en la posicion actual
    }

    // metodo para ir al producto anterior en el carrusel
    public void previous() {
        // decrementamos el indice y usamos modulo para hacerlo circular
        currentIndex = (currentIndex - 1 + products.size()) % products.size();
        updateUI(); // actualizamos la interfaz despues de cambiar el producto
    }

    // metodo para ir al siguiente producto en el carrusel
    public void next() {
        // incrementamos el indice y usamos modulo para hacerlo circular
        currentIndex = (currentIndex + 1) % products.size();
        updateUI(); // actualizamos la interfaz despues de cambiar el producto
    }

    // metodo que intenta ajusta los botones segun el producto actual y el numero total de productos
    protected void adjustCarruselButtons(int currentElement, int numberOfElements) {
        //si estamos en el primer producto, deshabilitamos el boton 'anterior'
        boolean isPreviousButtonEnabled = currentElement > 0;
        
        // si estamos en el ultimo producto, deshabilitamos el boton 'siguiente'
        boolean isNextButtonEnabled = currentElement < numberOfElements - 1;
        
        // actualizamos los botones, habilitandolos o deshabilitandolos
        updateButtonState("H", isPreviousButtonEnabled); // boton H (anterior)
        updateButtonState("G", isNextButtonEnabled); // boton G (siguiente)
    }

    // metodo protegido para configurar los botones de la pantalla
    protected void configureScreenButtons() {
        // configuramos los botones segun el estado actual
        adjustCarruselButtons(currentIndex, products.size());
    }

    // metodo para actualizar los botones segun su estado
    private void updateButtonState(String buttonName, boolean isEnabled) {
        // aqui actualizas el estado de los botones en la interfaz grafica del kiosco
        // en lugar de imprimir, habilitaras o deshabilitaras los botones reales
        if (isEnabled) {
            // habilitar el boton en la interfaz
            System.out.println("Boton " + buttonName + " habilitado");
        } else {
            // deshabilitar el boton en la interfaz
            System.out.println("Boton " + buttonName + " deshabilitado");
        }
    }

    // metodo para actualizar la interfaz completa (descripcion e imagen)
    private void updateUI() {
        // obtener el producto actual
        Product currentProduct = getCurrentProduct();
        
        // actualizar la imagen en la interfaz (esto seria un ejemplo)
        updateImage(currentProduct.getImagePath()); // asumiendo que el producto tiene una ruta de imagen
        
        // actualizar la descripcion en la interfaz
        updateDescription(currentProduct.getDescription()); // actualiza la descripcion del producto
    }

    // metodo para actualizar la imagen del producto en la interfaz
    private void updateImage(String imagePath) {
        // actualizar la imagen en la interfaz grafica del kiosco
        // aqui se debe poner el codigo real para cambiar la imagen en la UI
        System.out.println("Actualizando imagen con: " + imagePath);
    }

    // metodo para actualizar la descripcion del producto en la interfaz
    private void updateDescription(String description) {
        // actualizar la descripcion en la interfaz grafica del kiosco
        // aqui se debe poner el codigo real para cambiar la descripcion en la UI
        System.out.println("Actualizando descripcion: " + description);
    }
}





