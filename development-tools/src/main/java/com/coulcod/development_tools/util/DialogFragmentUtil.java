package com.coulcod.development_tools.util;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.Window;

/**
 * Created by macbookpro on 07.10.16.
 */
public class DialogFragmentUtil {

    public static void removeDefaultBackground(@NonNull DialogFragment dialog) {
        Dialog d = dialog.getDialog();
        if (d != null) {
            Window w = d.getWindow();
            if (w != null) {
                w.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
    }

}
