package com.coulcod.recipescatalog.entity.util.validation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class NumberFieldValidation {

    /**
     * Check is text in {@link String} is empty of {@link String} is null.
     * @param text Target {@link String} text
     * @return {@link boolean} true if text if empty, false otherwise.
     */
    public static boolean empty(@Nullable String text) {
        return text == null || text.trim().isEmpty();
    }

    /**
     * Check is text in {@link String} consist of digits only.
     * @param text {@link String} to check
     * @return Return true if {@link String} contains nothing except of digits, return false otherwise.
     */
    public static boolean numberOnly(@NonNull String text) {
        return text.trim().matches("^[0-9]+$");
    }

    /**
     * Check is text in {@link String} consist of digits only.
     * @param text {@link String} to check
     * @return Return true if {@link String} contains nothing except of digits, return false otherwise.
     */
    public static boolean isDecimalNumber(@NonNull String text) {
        String trimmed = text.trim();
        boolean result = trimmed.matches("^\\d+(\\.\\d+)?$");
        if (!result) result = trimmed.matches("^\\d+(\\,\\d+)?$");
        return result;
    }

}
