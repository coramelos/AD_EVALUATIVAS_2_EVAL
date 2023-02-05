
package Utils;

import java.util.UUID;

/**
 * Clase que define las funciones de creacion de  un identificador unico para 
 * cualquier objeto
 * @author cora
 */
public class IdCreator {

    /**
     * devuelve una cadena con el identificador
     * @return 
     */
    public static String randomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
