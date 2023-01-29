/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Models.Pedido;
import com.google.gson.Gson;

/**
 *
 * @author cora
 */
public class Deserializer {

    public static Object fromJsonToString(String mensaje) {

        Gson gson = new Gson();
        Object object = gson.fromJson(mensaje, Pedido.class);

        return object;
    }

}
