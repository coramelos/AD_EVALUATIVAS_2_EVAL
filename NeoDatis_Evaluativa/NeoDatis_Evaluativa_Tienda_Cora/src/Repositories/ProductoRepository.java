
package Repositories;

import Models.Producto;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;

import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;



/**
 * Clase que define las funciones de creacion de ProductoRepository
 * @author Cora
 */
public class ProductoRepository {
    
    /**
     *  Atributos de la clase para hacer las acciones necesarias
     */
    private DataBaseNeodatis dataBaseNeodatis;
   

    /**
     * Contructor de la clase MostrarPedidos. Inicializaremos componentes para
     * cargar los datos necesarios, ademas de las clase correspondiente service.
     */
    public ProductoRepository() {
        
        this.dataBaseNeodatis =  new DataBaseNeodatis();
    }

    
    /**
     * Funcion que guarda un objeto de tipo producto
     * @param producto 
     */
    public void save(Producto producto) {
        ODB odb = this.dataBaseNeodatis.open();
        odb.store(producto);
        odb.commit();
        this.dataBaseNeodatis.close(odb);
    }
    
    /**
     * Recoge una lista de todos los productos existentes en la base de datos
     * @return productos
     */
    public ArrayList<Producto> getAll() {
        ODB odb = this.dataBaseNeodatis.open();
        ArrayList<Producto>productos = new ArrayList<>();
        
        Objects<Producto> objects = odb.getObjects(Producto.class);
        
        while(objects.hasNext()){
            productos.add(objects.next());
        }
        this.dataBaseNeodatis.close(odb);
        return productos;       
        
    }

    /**
     * Recibe un producto para modificarlo en la base de datos
     * @param producto 
     */
    public void updateProducto(Producto producto) {
       String  nombre = producto.getNombre();
       int stock = producto.getStock();
       
       ODB odb = this.dataBaseNeodatis.open();
       IQuery query = new CriteriaQuery(Producto.class, Where.equal("nombre", nombre));
       
       Producto productoDeBD = (Producto)odb.getObjects(query).getFirst();
       productoDeBD.setStock(stock);
       
       odb.store(productoDeBD);
       odb.commit();
       this.dataBaseNeodatis.close(odb);   
    }

    
    /**
     * Obtiene un producto segun el parametro recibido de nombre y una conexion creada
     * @param nombreProducto
     * @param dataBaseConection
     * @return Producto
     */
    public Producto  findProductByProductNameAndDataBase(String nombreProducto,ODB dataBaseConection) {
       
        IQuery query = new CriteriaQuery(Producto.class,Where.equal("nombre", nombreProducto));
        Producto producto = (Producto) dataBaseConection.getObjects(query).getFirst();
        return producto;

    }
    
    
    
}
