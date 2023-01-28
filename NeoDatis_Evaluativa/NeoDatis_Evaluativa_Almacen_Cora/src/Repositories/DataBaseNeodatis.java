
package Repositories;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author cora
 */
public class DataBaseNeodatis {
    
    
    public ODB open() {
        ODB odb = ODBFactory.open("Almacen.db");
        return odb;
    }
    
    public void close(ODB odb){
        odb.close();
    }
    
}
