package Models;

import Utils.IdCreator;
import java.util.ArrayList;

/**
 * Clase que define las funciones de creacion de usuarios
 * @author Cora
 */
public class Usuario {

    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private String idUsuario;
    private String nombre;
    private String email;

    private ArrayList<Pedido> listaPedidos;

    
     /**
     * Contructor de la clase Usuario. Inicializaremos componentes para
     * cargar los datos necesarios.
     */
    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.idUsuario = IdCreator.randomId();
        this.listaPedidos = new ArrayList<Pedido>();
    }

    /**
     * devuelve el identificador 
     * @return 
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * sete el identificador
     * @param idUsuario 
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * devuelve el nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * setea el nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * devuelve el email
     * @return 
     */
    public String getEmail() {
        return email;
    }

    /**
     * setea el email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * devuelve una lista de pedidos asociada
     * @return 
     */
    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    /**
     * setea una nueva lista de pedidos
     * @param listaPedidos 
     */
    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    /**
     * Devuelve informacion completa de usuario
     * @return 
     */
    @Override
    public String toString() {
        return "Usuario{" + ", nombre=" + nombre + ", email=" + email + ", listaPedidos=" + listaPedidos + '}';
    }

    /**
     * anñade un pedido a la lista de pedidos
     * @param pedido 
     */
    public void addPedido(Pedido pedido) {
        this.listaPedidos.add(pedido);
    }

}
