
package Clases;

import Utils.IdCreator;
import java.util.ArrayList;

/**
 *
 * @author Cora
 */
public class Pedido {
    
    private String idPedido;
    private String estado;
  
    ArrayList<Producto> listaProductos;
    private final String PENDIENTE = "pendiente";
    
    public Pedido(ArrayList<Producto> listaProductos ) {
        this.idPedido = IdCreator.randomId();
       
        this.listaProductos = listaProductos;
        this.estado = PENDIENTE;
       
    }

    public Pedido() {
       
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
 

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "estado=" + estado + ", listaProductos=" + listaProductos + '}';
    }

   

    
}
