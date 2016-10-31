package com.coulcod.recipescatalog.entity.util;

import android.support.annotation.NonNull;

import java.util.Random;

public class HashUtil {

    private static String SYMBOLS = "1234567890-=`!@#$%^&*()_+qwertyuiop[]asdfghjkl;'zxcvbnm,./?><MNBVCXZASDFGHJKL:}{POIUYTREWQ";

    /**
     * Genereta unique <code>{@link String}</code> with sybols from <code>{@link HashUtil#SYMBOLS}</code>.
     * @param length count of symbols in result hash string
     * @return has text
     */
    @NonNull
    public static String generateHash(int length) {
        String result = "";
        Random random = new Random();
        for (int i=0; i<length; i++) {
            result += SYMBOLS.charAt(random.nextInt(SYMBOLS.length()-1));
        }
        return result;
    }

}
