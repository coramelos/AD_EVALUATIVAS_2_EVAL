
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Cora
 */
public class Usuario {
        
    private String idUsuario;
    private String nombre;
    private String email;
    
    private ArrayList<Pedido> listaPedidos;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
    
    public void idGenerate(){
    
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", listaPedidos=" + listaPedidos + '}';
    }
    
    
    
}
