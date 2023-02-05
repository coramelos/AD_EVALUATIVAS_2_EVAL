package Repositories;

import Models.Pedido;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 * Clase que define las funciones de creacion de PedidoRepository
 * @author cora
 */
public class PedidoRepository {

    /**
     * Atributos de la clase para hacer las acciones necesarias
     */
    private DataBaseNeodatis dataBaseNeodatis;

    
    /**
     * Contructor de la clase InicioAlmacen. PedidoRepository componentes para
     * cargar los datos necesarios, ademas de las clase correspondiente service.
     */
    public PedidoRepository() {

        this.dataBaseNeodatis = new DataBaseNeodatis();
    }

    
    /**
     * Obtencion del listaado de todos los pedidos
     * @return 
     */
    public ArrayList<Pedido> getAll() {
        ODB odb = this.dataBaseNeodatis.open();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Objects<Pedido> objects = odb.getObjects(Pedido.class);
        while (objects.hasNext()) {
            pedidos.add(objects.next());
        }
        this.dataBaseNeodatis.close(odb);
        return pedidos;
    }

    /**
     * Guarda un objeto pedido
     * @param pedido 
     */
    public void save(Pedido pedido) {

        ODB odb = this.dataBaseNeodatis.open();
        odb.store(pedido);
        odb.commit();
        this.dataBaseNeodatis.close(odb);
    }

    
    /**
     * Devuelve un pedido filtrado por su id y manteniendo una 
     * conexion previa recibida
     * @param idPedido
     * @param odb
     * @return 
     */
    public Pedido findByIdAndDataBase(String idPedido, ODB odb) {
        IQuery query = new CriteriaQuery(Pedido.class, Where.equal("idPedido", idPedido));
        Pedido pedido = (Pedido) odb.getObjects(query).getFirst();
        return pedido;
    }

    
    /**
     * Devuelve un pedido encontrado por su identificador 
     * @param idPedido
     * @return 
     */
    public Pedido findById(String idPedido) {
        ODB odb = this.dataBaseNeodatis.open();
        IQuery query = new CriteriaQuery(Pedido.class, Where.equal("idPedido", idPedido));
        Pedido pedido = (Pedido) odb.getObjects(query).getFirst();
        this.dataBaseNeodatis.close(odb);
        return pedido;
    }

    /**
     * Modificacion de un pedido
     * @param pedido 
     */
    public void update(Pedido pedido) {
        String id = pedido.getIdPedido();
        String estado = pedido.getEstado();
        ODB odb = this.dataBaseNeodatis.open();
        IQuery query = new CriteriaQuery(Pedido.class, Where.equal("idPedido", id));
        Pedido pedidoBD = (Pedido) odb.getObjects(query).getFirst();
        pedidoBD.setEstado(estado);
        odb.store(pedidoBD);
        odb.commit();
        this.dataBaseNeodatis.close(odb);
    }
}
