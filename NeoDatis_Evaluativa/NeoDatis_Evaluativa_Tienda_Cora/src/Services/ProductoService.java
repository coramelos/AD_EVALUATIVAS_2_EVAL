
package Services;


import Clases.Pedido;
import Clases.Producto;

import Repositories.ProductoRepository;
import java.util.ArrayList;
import org.neodatis.odb.ODB;


/**
 *
 * @author Cora
 */
public class ProductoService {
    
    
    private ProductoRepository productoRepository;

    public ProductoService() {
        
        this.productoRepository = new ProductoRepository();
    }

    public void save(String nombre, int stock, Double precio) {
        Producto producto = new Producto(nombre, stock, precio);
        this.productoRepository.save(producto);
    }

    public ArrayList<Producto> getAll() {
        return this.productoRepository.getAll();
    }

    public Producto findProductByProductNameAndDataBase(String nombreProducto, ODB dataBaseConection) {
       Producto producto = this.productoRepository.findProductByProductNameAndDataBase(nombreProducto, dataBaseConection);
        
        return producto;
    }
     public void updateStock(Producto producto) {
        this.productoRepository.updateProducto(producto);
    }
    
    
    
    
}
