package com.coulcod.recipescatalog.entity.util;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Simplify development part related with class {@link java.util.Date}.
 */
public class DateUtil {

    @NonNull
    public static Date currentDate() {
        return Calendar.getInstance().getTime();
    }

    @NonNull
    @SuppressLint("SimpleDateFormat")
    public static String currentDate(@NonNull String format) {
        String result;
        Date date = currentDate();
        DateFormat targetFormat = new SimpleDateFormat(format);
        result = targetFormat.format(date);
        return result;
    }

}
