package com.coulcod.recipescatalog.entity.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.support.annotation.NonNull;

/**
 * Created by seotm on 09.06.16.
 */

public class WindowUtil {

    /**
     * Check is screen in portrait orientation.
     * @param activity visible {@link Activity}
     * @return return {@link boolean} true if screen in portrait orientation, return false otherwise.
     */
    public static boolean isPortraitOrientation(@NonNull Activity activity) {
        return activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * Check is screen in landscape orientation.
     * @param activity visible {@link Activity}
     * @return return {@link boolean} true if screen in portrait orientation, return false otherwise.
     */
    public static boolean isLandscapeOrientation(@NonNull Activity activity) {
        return activity.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

}
