
package Repositories;

import Models.Pedido;
import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

/**
 * @author Cora
 */
public class PedidoRepository {

    
    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private DataBaseNeodatis dataBaseNeodatis;

    /**
     * Contructor de la clase PedidoRepository. Inicializaremos componentes para
     * cargar los datos necesarios.
     */
    public PedidoRepository() {
        this.dataBaseNeodatis =  new DataBaseNeodatis();
    }

    
    /**
     * Funcion que obtiene un listado de 
     * @return 
     */
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
