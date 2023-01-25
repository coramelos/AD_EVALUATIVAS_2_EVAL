
package Repositories;


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

   

        
}
