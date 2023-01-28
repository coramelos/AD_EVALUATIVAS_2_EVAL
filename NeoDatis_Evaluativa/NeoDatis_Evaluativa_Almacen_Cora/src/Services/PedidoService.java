/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Clases.Pedido;
import Repositories.PedidoRepository;
import Utils.Deserializer;
import java.util.ArrayList;

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

}
