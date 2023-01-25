/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Clases.Usuario;
import Repositories.UsuarioRepository;
import java.util.ArrayList;
import org.neodatis.odb.ODB;

/**
 *
 * @author Cora
 */
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }

   

    public void save(String nombre, String email) {
        
        Usuario usuario = new Usuario(nombre, email);
        this.usuarioRepository.save(usuario);
    }

    
    public ArrayList<Usuario> getAll() {
        return this.usuarioRepository.getAll();
    
    }

    public void saveByDataBaseConnection(Usuario usuario, ODB dataBaseConection) {
        this.usuarioRepository.saveByDataBaseConnection(usuario,dataBaseConection);
    }

    public Usuario findByEmailAndDataBase(String email, ODB dataBaseConection) {
        Usuario usuario = this.usuarioRepository.findByEmailAndDataBase(email, dataBaseConection);
        return usuario;
    }

    
    
    
    
}
