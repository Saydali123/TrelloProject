package uz.elmurodov.utils;

import java.util.UUID;

/**
 * @author Elmurodov Javohir, Fri 4:58 PM. 11/5/2021
 */
public class BaseUtil {
    public static String generateUniqueID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
