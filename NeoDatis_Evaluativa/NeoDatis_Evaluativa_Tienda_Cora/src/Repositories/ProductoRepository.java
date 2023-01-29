/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Producto;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;

import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;



/**
 *
 * @author Cora
 */
public class ProductoRepository {
    private DataBaseNeodatis dataBaseNeodatis;
   

    public ProductoRepository() {
        
        this.dataBaseNeodatis =  new DataBaseNeodatis();
    }

    public void save(Producto producto) {
        
        ODB odb = this.dataBaseNeodatis.open();
        odb.store(producto);
        odb.commit();
        this.dataBaseNeodatis.close(odb);
    }

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

    public Producto  findProductByProductNameAndDataBase(String nombreProducto,ODB dataBaseConection) {
       
        IQuery query = new CriteriaQuery(Producto.class,Where.equal("nombre", nombreProducto));
        Producto producto = (Producto) dataBaseConection.getObjects(query).getFirst();
        return producto;

    }
    
    
    
}
