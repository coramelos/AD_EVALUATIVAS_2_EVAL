package Repositories;

import Models.Pedido;
import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author cora
 */
public class PedidoRepository {

    private DataBaseNeodatis dataBaseNeodatis;

    public PedidoRepository() {

        this.dataBaseNeodatis = new DataBaseNeodatis();
    }

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

    public void save(Pedido pedido) {

        ODB odb = this.dataBaseNeodatis.open();
        odb.store(pedido);
        odb.commit();
        this.dataBaseNeodatis.close(odb);
    }

    public Pedido findByIdAndDataBase(String idPedido, ODB odb) {
        IQuery query = new CriteriaQuery(Pedido.class, Where.equal("idPedido", idPedido));
        Pedido pedido = (Pedido) odb.getObjects(query).getFirst();
        return pedido;
    }

    public Pedido findById(String idPedido) {
        ODB odb = this.dataBaseNeodatis.open();
        IQuery query = new CriteriaQuery(Pedido.class, Where.equal("idPedido", idPedido));
        Pedido pedido = (Pedido) odb.getObjects(query).getFirst();
        this.dataBaseNeodatis.close(odb);
        return pedido;

    }

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
