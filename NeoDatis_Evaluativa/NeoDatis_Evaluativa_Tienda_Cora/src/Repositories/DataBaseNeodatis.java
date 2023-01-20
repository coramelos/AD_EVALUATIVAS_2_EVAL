
package Repositories;

import Clases.Producto;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;


/**
 *
 * @author Cora
 */
public class DataBaseNeodatis {
    
        
    public ODB open() {
        ODB odb = ODBFactory.open("Tienda.db");
        return odb;
    }
    
    public void close(ODB odb){
        odb.close();
    
    }

    public void save(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
}
