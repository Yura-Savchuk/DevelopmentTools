package com.coulcod.recipescatalog.entity.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.widget.EditText;

public class InputAlertDialogFactory {

    /**
     * Create dialog with EditText with id @android.R.id.inputExtractEditText and buttons.
     * @param context App Context.
     * @param title Dialog title.
     * @param hint EditText hint.
     * @param inputType Input type for EditText, see {@link InputType}.
     * @param acceptButtonText Text for accept button.
     * @param cancelButtonText Text for cancel button.
     * @param onAcceptButtonClickListener Listener for accept button.
     * @param onCancelButtonClickListener Listener for cancel button.
     * @return {@link AlertDialog}
     */
    @NonNull
    public static AlertDialog dialog(
            @NonNull Context context,
            @NonNull String title,
            @NonNull String hint,
            int inputType,
            @NonNull String acceptButtonText,
            @NonNull String cancelButtonText,
            @Nullable DialogInterface.OnClickListener onAcceptButtonClickListener,
            @Nullable DialogInterface.OnClickListener onCancelButtonClickListener
    ) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final EditText input = new EditText(context);
        input.setId(android.R.id.inputExtractEditText);
        input.setInputType(inputType);
        input.setHint(hint);
        float dpi = context.getResources().getDisplayMetrics().density;
        builder.setView(input,  (int)(24*dpi), (int)(5*dpi), (int)(14*dpi), (int)(5*dpi) );
        builder.setPositiveButton(acceptButtonText, onAcceptButtonClickListener);
        builder.setNegativeButton(cancelButtonText, onCancelButtonClickListener);
        builder.setTitle(title);
        return builder.create();
    }

}
