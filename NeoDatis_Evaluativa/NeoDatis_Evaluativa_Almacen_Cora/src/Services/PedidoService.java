
package Services;

import Models.Pedido;
import Repositories.PedidoRepository;
import Utils.Deserializer;
import java.util.ArrayList;
import org.neodatis.odb.ODB;

/**
 * Clase que define las funciones de creacion de PedidoService
 * @author cora
 */
public class PedidoService {

    /**
     *  Atributos de la clase para hacer las acciones necesarias
     */
    private PedidoRepository pedidoRepository;

    
    /**
     * Contructor de la clase PedidoService componentes para
     * cargar los datos necesarios, ademas de las clase correspondiente service.
     */
    public PedidoService() {
        this.pedidoRepository = new PedidoRepository();

    }

    /**
     * Obtencion del listaado de todos los pedidos
     * @return 
     */
    public ArrayList<Pedido> getAll() {
        return this.pedidoRepository.getAll();
    }

    
    /**
     * Guardaun pedido despues de deserializarlo
     * @param message 
     */
    public void save(String message) {
        Pedido pedido = (Pedido) Deserializer.fromJsonToString(message);
      this.pedidoRepository.save(pedido);

    }

    
    /**
     *  Devuelve un pedido filtrado por su id y manteniendo una 
     * conexion previa recibida
     * @param idPedido
     * @param odb
     * @return 
     */
    public Pedido findByIdAndDataBase(String idPedido, ODB odb) {
         return this.pedidoRepository.findByIdAndDataBase(idPedido,odb);
    }

    
    /*
     * Devuelve un pedido encontrado por su identificador 
     * @param idPedido
     * @return 
     */
    public Pedido findById(String idPedido) {
        return this.pedidoRepository. findById(idPedido);
    }

    
    /**
     * Modificacion de un pedido
     * @param pedido 
     */
    public void update(Pedido pedido) {
        this.pedidoRepository.update(pedido);
    }

}
