/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Clases.Pedido;
import Repositories.PedidoRepository;
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

    public void save(ArrayList<Pedido> pedidos) {

        pedidos.forEach((pedido) -> {
            this.pedidoRepository.save(pedido);
        });
    }

    public void AddMessage(String message) {
       // Pedido pedido = (Pedido) Deserializer.fromJsonToString(message);
        System.out.println(message);

    }

}
