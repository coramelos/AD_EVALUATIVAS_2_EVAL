
package Clases;

import Utils.IdCreator;

/**
 *
 * @author Cora
 */
public class Producto {
    
    private String id;
    private String nombre;
    private int stock;
    private double precio;

    public Producto( String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.id = IdCreator.randomId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{"  + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + '}';
    }
    
    
    
}
