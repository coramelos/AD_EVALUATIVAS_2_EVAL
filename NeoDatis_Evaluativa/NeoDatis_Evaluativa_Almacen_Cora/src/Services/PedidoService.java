
package Services;

import Models.Pedido;
import Repositories.PedidoRepository;
import Utils.Deserializer;
import java.util.ArrayList;
import org.neodatis.odb.ODB;

/**
 *
 * @author cora
 */
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoService() {
        this.pedidoRepository = new PedidoRepository();

    }

    public ArrayList<Pedido> getAll() {
        return this.pedidoRepository.getAll();
    }

    public void save(String message) {
        Pedido pedido = (Pedido) Deserializer.fromJsonToString(message);
      this.pedidoRepository.save(pedido);

    }

    public Pedido findByIdAndDataBase(String idPedido, ODB odb) {
         return this.pedidoRepository.findByIdAndDataBase(idPedido,odb);
    }

    public Pedido findById(String idPedido) {
        return this.pedidoRepository. findById(idPedido);
    }

    public void update(Pedido pedido) {
        this.pedidoRepository.update(pedido);
    }

}
