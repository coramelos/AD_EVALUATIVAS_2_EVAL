
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

  
/*
    public void save(String idUsuario, ArrayList<Producto> listaProductos) {
        Pedido pedido = new Pedido( listaProductos);
        updateStock(listaProductos);
        this.pedidoRepository.save(pedido);
    }
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

    public Pedido createPedido(ArrayList<Producto> productos)throws NullPointerException{
        Pedido pedido = new Pedido(productos);
        return pedido;
    }
    
    

   
   
    
}
