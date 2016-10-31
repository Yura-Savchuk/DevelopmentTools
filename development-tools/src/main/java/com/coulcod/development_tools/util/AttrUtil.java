package com.coulcod.development_tools.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;

public class AttrUtil {

    public static int getAttrValue(int attr, @NonNull Context context) {
        int result = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            result = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }
        return result;
    }

}
