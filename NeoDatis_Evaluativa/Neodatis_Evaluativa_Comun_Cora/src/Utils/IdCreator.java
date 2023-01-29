/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.UUID;

/**
 *
 * @author cora
 */
public class IdCreator {

    public static String randomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
