
package Repositories;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author Cora
 */
public class NeodatisDataBase {
    
    private ODB odb;

    public ODB NeodatisOdb() {
        this.odb = ODBFactory.open("Tienda.db");
        return odb;
    }
    
    public void closeDB(ODB odb){
        odb.close();
    
    }
    
    
    
}
