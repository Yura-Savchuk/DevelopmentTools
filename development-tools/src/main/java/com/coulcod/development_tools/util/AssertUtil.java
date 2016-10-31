package com.coulcod.development_tools.util;

public class AssertUtil {

    public static void _assert(boolean condation, String message) {
        if (!condation) {
            throw new IllegalArgumentException(message);
        }
    }

}
