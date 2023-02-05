package Models;

import Utils.IdCreator;
import java.util.ArrayList;

/**
 * Clase que define las funciones de creacion de Pedido
 * @author Cora
 */
public class Pedido {

    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private final String PENDIENTE = "PENDIENTE";
    private String idPedido;
    private String estado;

    ArrayList<Producto> listaProductos;

    
    /**
     * Contructor de la clase Usuario. Inicializaremos componentes para
     * cargar los datos necesarios.
     */
    public Pedido(ArrayList<Producto> listaProductos) {
        this.idPedido = IdCreator.randomId();
        this.listaProductos = listaProductos;
        this.estado = PENDIENTE;
    }

    /**
     * devuelve el estado del pedido
     * @return 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Setea el nuevo estado del pedido
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el identificador del pedido
     * @return 
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * Setea el identificador del pedido
     * @param idPedido 
     */
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * devuelve la lista de productos
     * @return 
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * setea una lista de productos
     * @param listaProductos 
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * muesta la informacion completa de la clase
     * @return 
     */
    @Override
    public String toString() {
        return "Pedido{" + "estado=" + estado + ", listaProductos=" + listaProductos + '}';
    }

}
