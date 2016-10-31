package com.coulcod.development_tools.util;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by seotm on 08.06.16.
 */

public class ResourceConverter {

    /**
     * Convert {@link int} dp value to {@link float} pixel value.
     * @param dp Converted dp value
     * @param context Application context
     * @return retrun {@link float} pixel value.
     */
    public static float dpToPixel(int dp, Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
