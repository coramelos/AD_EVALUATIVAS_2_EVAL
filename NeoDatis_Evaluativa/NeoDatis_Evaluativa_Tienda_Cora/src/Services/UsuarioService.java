/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Clases.Usuario;
import Repositories.UsuarioRepository;
import java.util.ArrayList;

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
    
    
    
}
