
package Repositories;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;


/**
 *Clase encargada de comunicarse con la base de datos.
 * @author Cora
 */
public class DataBaseNeodatis {
    
    /**
     * Funcion para establecer la conexion
     * @return 
     */
    public ODB open() {
        ODB odb = ODBFactory.open("Tienda.db");
        return odb;
    }
    
    /**
     * Funcion para cerrar la conexion
     * @param odb 
     */
    public void close(ODB odb){
        odb.close();
    }
}
