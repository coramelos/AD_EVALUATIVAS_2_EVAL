
package Repositories;

import Models.Usuario;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * Clase que define las funciones de creacion de UsuarioRepository
 * @author cora
 */
public class UsuarioRepository {

    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private DataBaseNeodatis dataBaseNeodatis;

    
    /**
     * Contructor de la clase UsuarioRepository. Inicializaremos componentes para
     * cargar los datos necesarios.
     */
    public UsuarioRepository() {
        this.dataBaseNeodatis = new DataBaseNeodatis();
    }

    /**
     * Guarda un objeto Usuario 
     * @param usuario 
     */
    public void save(Usuario usuario) {
        ODB odb = this.dataBaseNeodatis.open();
        odb.store(usuario);
        this.dataBaseNeodatis.close(odb);
    }

    
    /**
     * Obtiene un listado de todos los usuarios de la base de datos
     * @return 
     */
    public ArrayList<Usuario> getAll() {
        
        ODB odb = this.dataBaseNeodatis.open();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Objects<Usuario> objects = odb.getObjects(Usuario.class);
        while (objects.hasNext()) {
            usuarios.add(objects.next());
        }
        this.dataBaseNeodatis.close(odb);
        return usuarios;
    }

    /**
     * 
     * @param usuario
     * @param dataBaseConection 
     */
    public void saveByDataBaseConnection(Usuario usuario, ODB dataBaseConection) {
        IQuery query = new CriteriaQuery(Usuario.class, Where.equal("email", usuario.getEmail()));
        Usuario usuarioBd = (Usuario) dataBaseConection.getObjects(query).getFirst();
        usuarioBd.setListaPedidos(usuario.getListaPedidos());

        dataBaseConection.store(usuarioBd);
        dataBaseConection.commit();
    }

    /**
     * obtiene un objeto de tipo Usuario segun los parametros de email y una 
     * conexion.
     * @param email
     * @param dataBaseConection
     * @return 
     */
    public Usuario findByEmailAndDataBase(String email, ODB dataBaseConection) {
        IQuery query = new CriteriaQuery(Usuario.class, Where.equal("email", email));
        Usuario usuarioBd = (Usuario) dataBaseConection.getObjects(query).getFirst();
        return usuarioBd;
    }

}
