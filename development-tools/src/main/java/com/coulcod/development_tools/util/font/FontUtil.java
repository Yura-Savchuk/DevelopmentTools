package com.coulcod.development_tools.util.font;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.widget.Button;

/**
 * Created by seotm on 07.06.16.
 */

public class FontUtil {

    /**
     * Set font to {@link Button} text from assets folder.
     * @param button Target Button to change font.
     * @param font Font name in assets folder.
     */
    public static void setFontFromAssets(@NonNull Button button, @NonNull String font) {
        Typeface typeface = Typeface.createFromAsset(button.getContext().getAssets(), font);
        button.setTypeface(typeface);
    }

}
