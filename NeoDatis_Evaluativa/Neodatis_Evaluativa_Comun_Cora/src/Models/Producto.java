package Models;

import Utils.IdCreator;

/**
 * Clase que define las funciones de creacion de Producto
 * @author Cora
 */
public class Producto {

    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private String id;
    private String nombre;
    private int stock;
    private double precio;

    
    /**
     * Contructor de la clase Usuario. Inicializaremos componentes para
     * cargar los datos necesarios.
     * @param nombre
     * @param stock
     * @param precio 
     */
    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.id = IdCreator.randomId();
    }

    /**
     * devuelve el identificador 
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * sete el identificador
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * devuelve el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *  setea el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el stock
     * @return 
     */
    public int getStock() {
        return stock;
    }

    /**
     * Setea el stock nuevo
     * @param stock 
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * devuelve el precio
     * @return 
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * setea el nuevo precio
     * @param precio 
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve informacion completa de usuario
     * @return 
     */
    @Override
    public String toString() {
        return "Producto{" + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + '}';
    }

}
