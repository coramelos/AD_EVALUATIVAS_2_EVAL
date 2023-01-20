
package Repositories;

import Clases.Pedido;

import org.neodatis.odb.ODB;

/**
 *
 * @author Cora
 */
public class PedidoRepository {

    
    
    private DataBaseNeodatis dataBaseNeodatis;

    public PedidoRepository() {
        
        this.dataBaseNeodatis =  new DataBaseNeodatis();
    }
    
    
    public void save(Pedido pedido) {
        ODB odb = this.dataBaseNeodatis.open();
        odb.store(pedido);
        
        this.dataBaseNeodatis.close(odb); 
    }

    
   
    
}
