package com.coulcod.development_tools.util;

import android.support.annotation.NonNull;
import android.text.Layout;
import android.widget.TextView;

public class TextViewUtil {
    public static boolean isTextEllipsised(@NonNull TextView textView) {
        boolean result = false;
        Layout l = textView.getLayout();
        if (l != null) {
            int lines = l.getLineCount();
            result = lines > 0 && l.getEllipsisCount(lines-1) > 0;
        }
        return result;
    }
}
