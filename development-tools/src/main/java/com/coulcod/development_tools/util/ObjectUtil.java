package com.coulcod.recipescatalog.entity.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.TextView;

public class ObjectUtil {

    public static<T> boolean equals(T object1, T object2) {
        boolean result = true;
        if (object1 != null ? !object1.equals(object2) : object2 != null) {
            result = false;
        }
        return result;
    }

    @SafeVarargs
    public static<T> boolean equals(T object1, T object2, T ... objects) {
        boolean result = false;
        if (object1 != null) {
            if (object2 != null && object2.equals(object1)) {
                result = true;
            } else {
                for (T o : objects) {
                    if (object1.equals(o)) {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Method to simplify source like this <code>object != null ? object : anotherObject</code>
     * @param nullable value can be null, if valuer nonnull that will be result
     * @param nonnull possible result if <var>nullable</var> is null
     * @param <T> target class
     * @return one of <var>nullable</var> or <var>nonnull</var>.
     */
    public static<T> T oneOf(@Nullable T nullable, T nonnull) {
        T result;
        if (nullable == null) {
            result = nonnull;
        } else {
            result = nullable;
        }
        return result;
    }

    public static boolean isNonnull(@Nullable Object ... objects) {
        boolean nonnull = true;
        if (objects != null) {
            for (Object o : objects) {
                if (o == null) {
                    nonnull = false;
                    break;
                }
            }
        } else {
            nonnull = false;
        }
        return nonnull;
    }

    public static boolean isNullOneOF(@Nullable Object ... objects) {
        return !isNonnull(objects);
    }
}
