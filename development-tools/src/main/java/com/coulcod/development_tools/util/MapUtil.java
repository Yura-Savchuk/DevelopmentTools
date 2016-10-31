package com.coulcod.recipescatalog.entity.util;

import android.support.annotation.NonNull;

import java.util.Map;

/**
 * Created by macbookpro on 08.07.16.
 */
public class MapUtil {

    public static<K,V> boolean isEmpty(Map<K,V> map) {
        return !(map != null && map.keySet().size() != 0);
    }

    public static<T> boolean isContains(@NonNull Map<T, ?> data, T ... keys) {
        boolean result = true;
        for (T key : keys) {
            if (!data.containsKey(key)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
