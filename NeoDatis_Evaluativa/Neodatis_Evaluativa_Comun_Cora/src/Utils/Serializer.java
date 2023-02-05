
package Utils;

import com.google.gson.Gson;

/**
 * Clase que define las funciones de creacion de Serializer.
 * Es la clase encargada de serializar un objeto y convertirlo a Json, en este
 * caso, un pedido.
 * @author cora
 */
public class Serializer {

    public static String toJson(Object o) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(o);

        return jsonString;
    }
}
