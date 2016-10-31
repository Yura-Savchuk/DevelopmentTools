package com.coulcod.development_tools.view.editText;

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
