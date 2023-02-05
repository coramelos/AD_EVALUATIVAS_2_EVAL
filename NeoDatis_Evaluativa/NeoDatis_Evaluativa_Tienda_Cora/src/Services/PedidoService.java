
package Services;

import Models.Pedido;
import Models.Producto;
import Repositories.PedidoRepository;
import Repositories.ProductoRepository;
import java.util.ArrayList;


/**
 * Clase que define las funciones de creacion de PedidoService
 * @author Cora
 */
public class PedidoService {
    
    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
   private  PedidoRepository pedidoRepository;
   private ProductoRepository productoRepository;

   
   /**
     * Contructor de la clase PedidoService. Inicializaremos componentes para
     * cargar los datos necesarios, ademas de las clase correspondiente service.
     */
    public PedidoService() {
        this.pedidoRepository = new PedidoRepository();
        this.productoRepository = new ProductoRepository();
    }

  
    /**
     * modificar una lista de todos los objetos de la clase que se encuentran 
     * en la base de datos
     * @param productos 
     */
    public void updateStock(ArrayList<Producto>productos){
       int stockActualizado=0;
        for(Producto producto : productos){
           stockActualizado = producto.getStock();
           stockActualizado--;
           producto.setStock(stockActualizado);
           
            this.productoRepository.updateProducto(producto);
        }
    }

    /**
     * 
     * @param productos
     * @return
     * @throws NullPointerException 
     */
    public Pedido createPedido(ArrayList<Producto> productos)throws NullPointerException{
        Pedido pedido = new Pedido(productos);
        return pedido;
    }

    /**
     * obtiene una lista de todos los objetos de la clase que se encuentran 
     * en la base de datos
     * @return 
     */
    public ArrayList<Pedido> getAll() {
      return this.pedidoRepository.getAll();  
    }
    
    

   
   
    
}
