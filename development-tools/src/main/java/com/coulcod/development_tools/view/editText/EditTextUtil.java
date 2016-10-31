package com.coulcod.recipescatalog.entity.view.editText;

import android.widget.EditText;

/**
 * That class simplify development.
 */
public class EditTextUtil {

    public static void setFocus(EditText editText){
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
    }

}
