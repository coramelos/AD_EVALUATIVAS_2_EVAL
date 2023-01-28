/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.google.gson.Gson;

/**
 *
 * @author cora
 */
public class Serializer {

    public static String toJson(Object o) {

        Gson gson = new Gson();
        String jsonString = gson.toJson(o);
        return jsonString;

    }

}
