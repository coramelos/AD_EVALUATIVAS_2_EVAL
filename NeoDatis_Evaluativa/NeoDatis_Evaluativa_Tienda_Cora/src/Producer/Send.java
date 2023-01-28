/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author cora
 */
public class Send {
    
   private final static String QUEUE_NAME = "pedidos";
    
    public static void toRabbit(String jSonString){
     
         ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
      
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
          
            channel.basicPublish("", QUEUE_NAME, null, jSonString.getBytes(StandardCharsets.UTF_8));
           
        }catch(Exception e){
            System.out.println(e);
        }
    
    }
    
}
