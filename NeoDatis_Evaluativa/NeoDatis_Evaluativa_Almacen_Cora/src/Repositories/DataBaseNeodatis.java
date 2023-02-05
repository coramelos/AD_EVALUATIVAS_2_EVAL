
package Repositories;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * Clase que define las funciones de creacion de las conexiones con la base de datos
 * @author cora
 */
public class DataBaseNeodatis {
    
    /**
     * Funcion de abertura de conexion con la base de datos
     * @return la conexion
     */
    public ODB open() {
        ODB odb = ODBFactory.open("Almacen.db");
        return odb;
    }
    
    /**
     * funcion para cerrar  conexion
     * @param odb 
     */
    public void close(ODB odb){
        odb.close();
    }
    
}
