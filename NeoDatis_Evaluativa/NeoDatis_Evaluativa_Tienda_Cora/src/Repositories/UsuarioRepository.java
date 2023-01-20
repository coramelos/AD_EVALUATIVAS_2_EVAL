/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Clases.Usuario;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;


/**
 *
 * @author cora
 */
public class UsuarioRepository {

    
    private DataBaseNeodatis dataBaseNeodatis;

    public UsuarioRepository() {
        
        this.dataBaseNeodatis =  new DataBaseNeodatis();
    }
    
      
    public void save(Usuario usuario) {
       
        ODB odb = this.dataBaseNeodatis.open();
        odb.store(usuario);
        
        this.dataBaseNeodatis.close(odb);    
    }

    public ArrayList<Usuario> getAll() {
         ODB odb = this.dataBaseNeodatis.open();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Objects<Usuario> objects = odb.getObjects(Usuario.class);
        while(objects.hasNext()){
            usuarios.add(objects.next());
        }
        this.dataBaseNeodatis.close(odb);
        return usuarios;
    }
    
    
   
    
    
}
