
package Repositories;

import Clases.Pedido;
import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

/**
 *
 * @author Cora
 */
public class PedidoRepository {

    
    
    private DataBaseNeodatis dataBaseNeodatis;

    public PedidoRepository() {
        
        this.dataBaseNeodatis =  new DataBaseNeodatis();
    }

    public ArrayList<Pedido> getAll() {
         ODB odb = this.dataBaseNeodatis.open();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Objects<Pedido> objects = odb.getObjects(Pedido.class);
        while(objects.hasNext()){
            pedidos.add(objects.next());
        }
        this.dataBaseNeodatis.close(odb);
        return pedidos; 
    }
    
   
    
   
    
}
