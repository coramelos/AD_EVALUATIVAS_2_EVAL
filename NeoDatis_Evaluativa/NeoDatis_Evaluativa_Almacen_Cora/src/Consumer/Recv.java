package Consumer;

import Services.PedidoService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cora
 */
public class Recv {

    /**
     * Atributos necesarios para para relizar las funciones
     */
    private final static String QUEUE_NAME = "pedidos";
    private PedidoService pedidoService;
    
    
    /**
     * Constructor que inicializa el service de la clase
     */
    public Recv() {
        this.pedidoService = new PedidoService();
    }
     
    
    /**
     * funcion que manda el objeto en formato de mensaje a Rabbit
     */
    public void fromRabbit() {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection;
        try {
            connection = factory.newConnection();
            Channel channel = connection.createChannel();
            
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
                this.pedidoService.save(message);
            };
            channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {

            });

        } catch (IOException ex) {
            Logger.getLogger(Recv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(Recv.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }

}
