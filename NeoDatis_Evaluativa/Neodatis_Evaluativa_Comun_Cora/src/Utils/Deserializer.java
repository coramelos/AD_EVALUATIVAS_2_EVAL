
package Utils;

import Models.Pedido;
import com.google.gson.Gson;

/**
 * Clase que define las funciones de creacion de Deserializer.
 * Es la clase encargada de deserializar una cadena (Json) en un objeto, en este
 * caso, un pedido.
 * @author cora
 */
public class Deserializer {

    /**
     * funcion encargada de deserializar.
     * devuelve un objeto
     * @param mensaje
     * @return 
     */
    public static Object fromJsonToString(String mensaje) {

        Gson gson = new Gson();
        Object object = gson.fromJson(mensaje, Pedido.class);

        return object;
    }

}
