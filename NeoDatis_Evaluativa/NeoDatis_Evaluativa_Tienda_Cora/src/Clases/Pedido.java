
package Clases;

import Utils.IdCreator;
import java.util.ArrayList;

/**
 *
 * @author Cora
 */
public class Pedido {
    
    private String idPedido;
  
    private String idUsuario;
    ArrayList<Producto> listaProductos;

    public Pedido(String idUsuario,ArrayList<Producto> listaProductos ) {
        this.idPedido = IdCreator.randomId();
        this.idUsuario = idUsuario;
        this.listaProductos = listaProductos;
       
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
 

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", idUsuario=" + idUsuario + ", listaProductos=" + listaProductos + '}';
    }

    
}
