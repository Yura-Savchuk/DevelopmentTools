package com.coulcod.recipescatalog.entity.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by macbookpro on 22.09.16.
 */
public class UrlUtil {

    @NonNull
    public static String getFullFileName(@Nullable String url) {
        String result;
        if (TextUtils.isEmpty(url)) {
            result = "";
        } else {
            int slashIndex = url.lastIndexOf("/");
            int lastIndex = url.length();
            if (slashIndex + 1 != lastIndex) {
                result = url.substring(url.lastIndexOf("/") + 1, url.length());
            } else {
                result = "";
            }
        }
        return result;
    }

}
