
package Services;

import Clases.Pedido;
import Clases.Producto;
import Repositories.PedidoRepository;
import Repositories.ProductoRepository;
import java.util.ArrayList;


/**
 *
 * @author Cora
 */
public class PedidoService {
    
   private  PedidoRepository pedidoRepository;
   private ProductoRepository productoRepository;

    public PedidoService() {
        
        this.pedidoRepository = new PedidoRepository();
        this.productoRepository = new ProductoRepository();
    }

  
    
    public void updateStock(ArrayList<Producto>productos){
       int stockActualizado=0;
        for(Producto producto : productos){
           stockActualizado = producto.getStock();
           stockActualizado--;
           producto.setStock(stockActualizado);
           
            this.productoRepository.updateProducto(producto);
        }
        
       
    }

    public Pedido createPedido(ArrayList<Producto> productos)throws NullPointerException{
        Pedido pedido = new Pedido(productos);
        return pedido;
    }

    public ArrayList<Pedido> getAll() {
      return this.pedidoRepository.getAll();  
    }
    
    

   
   
    
}
