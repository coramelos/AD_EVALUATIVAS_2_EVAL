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
    
   // private ConnectionFactory factory ;
    
    public static void toRabbit(String jSonString){
     
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
      
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            
            channel.queueDeclare(jSonString, false, false, false, null);
           
            channel.basicPublish("", jSonString, null, jSonString.getBytes(StandardCharsets.UTF_8));
            
        }catch(Exception e){
            System.out.println(e);
        }
    
    }
    
}
