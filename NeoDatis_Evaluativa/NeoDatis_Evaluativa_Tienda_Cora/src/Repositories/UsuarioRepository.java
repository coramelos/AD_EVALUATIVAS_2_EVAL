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
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


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

    public void saveByDataBaseConnection(Usuario usuario, ODB dataBaseConection) {
        
        IQuery query = new CriteriaQuery(Usuario.class, Where.equal("email", usuario.getEmail()));
        Usuario usuarioBd = (Usuario)dataBaseConection.getObjects(query).getFirst();
        usuarioBd.setListaPedidos(usuario.getListaPedidos());
    
        dataBaseConection.store(usuarioBd);
        dataBaseConection.commit();
        
    }

    public Usuario findByEmailAndDataBase(String email, ODB dataBaseConection) {
        
        IQuery query = new CriteriaQuery(Usuario.class, Where.equal("email", email));
         Usuario usuarioBd = (Usuario)dataBaseConection.getObjects(query).getFirst();
         return usuarioBd;
    }
    
    
   
    
    
}
