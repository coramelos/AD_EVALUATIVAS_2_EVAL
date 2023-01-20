
package Services;


import Clases.Producto;
import Repositories.DataBaseNeodatis;
import Repositories.ProductoRepository;
import java.util.ArrayList;


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
    
    
    
}
