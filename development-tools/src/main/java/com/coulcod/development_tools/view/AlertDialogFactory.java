package com.coulcod.recipescatalog.entity.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by seotm on 23.05.16.
 */

public class AlertDialogFactory {

    public interface OnResultListener {
        int EMPTY = -1;
        /**
         * Callback for some results.
         * @param result Return result int value or -1 if result is empty.
         */
        void onResult(int result);
    }

    private static final int EMPTY_RES = -1;

    /**
     * Calculate error case alert dialog.
     * @param context Application context
     * @param error Request error message.
     * @param titleStringId Identifier of title String resource
     * @param defaultMessageStringId Identifier of default case message String resource. Default message will apear if in @param requestErrorAndCaseMassageMap
     *                               error message will be not found.
     * @param retryButtonStringId Retry button text String identifier.
     * @param closeButtonStringId Close button text String identifier.
     * @param requestErrorAndCaseMassageMap Map of possibly request messages, if request message is considers with some one key from @param requestErrorAndCaseMassageMap
     *                                      then in dialog as the message will be appear String by resource id from value of @param requestErrorAndCaseMassageMap by that key.
     * @param onRetryButtonClick Listener for retry button.
     */
    public static AlertDialog requestErrorDialog(@NonNull Context context, @NonNull String error, int titleStringId, int defaultMessageStringId, int retryButtonStringId, int closeButtonStringId, @Nullable HashMap<String, Integer> requestErrorAndCaseMassageMap, @NonNull DialogInterface.OnClickListener onRetryButtonClick) {
        return simpleRequestErrorDialog(context, error, titleStringId, defaultMessageStringId, retryButtonStringId, closeButtonStringId, requestErrorAndCaseMassageMap, onRetryButtonClick)
                .create();
    }

    /**
     * Calculate error case alert dialog.
     * @param context Application context
     * @param error Request error message.
     * @param titleStringId Identifier of title String resource
     * @param defaultMessageStringId Identifier of default case message String resource. Default message will apear if in @param requestErrorAndCaseMassageMap
     *                               error message will be not found.
     * @param retryButtonStringId Retry button text String identifier.
     * @param closeButtonStringId Close button text String identifier.
     * @param requestErrorAndCaseMassageMap Map of possibly request messages, if request message is considers with some one key from @param requestErrorAndCaseMassageMap
     *                                      then in dialog as the message will be appear String by resource id from value of @param requestErrorAndCaseMassageMap by that key.
     * @param onRetryButtonClick Listener for retry button.
     * @param onDismissListener Listener for dismmiss dialog.
     */
    public static AlertDialog requestErrorDialog(@NonNull Context context, @NonNull String error, int titleStringId, int defaultMessageStringId, int retryButtonStringId, int closeButtonStringId, @Nullable HashMap<String, Integer> requestErrorAndCaseMassageMap, @NonNull DialogInterface.OnClickListener onRetryButtonClick, @NonNull DialogInterface.OnDismissListener onDismissListener) {
        return simpleRequestErrorDialog(context, error, titleStringId, defaultMessageStringId, retryButtonStringId, closeButtonStringId, requestErrorAndCaseMassageMap, onRetryButtonClick)
                .setOnDismissListener(onDismissListener)
                .create();
    }

    /**
     * Make Aler Dilag this massage, title and button.
     * @param context
     * @param title
     * @param message
     * @param closeButtonStringId
     * @param onCloseButtonClick
     * @return
     */
    public static AlertDialog messageDialog(@NonNull Context context, String title, String message, int closeButtonStringId, DialogInterface.OnClickListener onCloseButtonClick) {
        return simpleMessageDialog(context, title, message, closeButtonStringId, onCloseButtonClick)
                .create();
    }

    /**
     * Make Aler Dilag this massage, title and button.
     * @param context
     * @param titleStringId
     * @param messageStringId
     * @param closeButtonStringId
     * @param onCloseButtonClick
     * @return
     */
    public static AlertDialog messageDialog(@NonNull Context context, int titleStringId, int messageStringId, int closeButtonStringId, DialogInterface.OnClickListener onCloseButtonClick) {
        return messageDialog(context, titleStringId, context.getString(messageStringId), closeButtonStringId, onCloseButtonClick);
    }

    public static AlertDialog messageDialog(@NonNull Context context, int titleStringId, String message, int closeButtonStringId, DialogInterface.OnClickListener onCloseButtonClick) {
        return simpleMessageDialog(context, context.getString(titleStringId), message, closeButtonStringId, onCloseButtonClick)
                .create();
    }

    /**
     * Make Aler Dilag this massage, title and button.
     * @param context
     * @param titleStringId
     * @param messageStringId
     * @param closeButtonStringId
     * @param onCloseButtonClick
     * @param onDismissListener
     * @return
     */
    public static AlertDialog messageDialog(@NonNull Context context, int titleStringId, int messageStringId, int closeButtonStringId, DialogInterface.OnClickListener onCloseButtonClick, DialogInterface.OnDismissListener onDismissListener) {
        return simpleMessageDialog(context, context.getString(titleStringId), context.getString(messageStringId), closeButtonStringId, onCloseButtonClick)
                .setOnDismissListener(onDismissListener)
                .create();
    }

    private static AlertDialog.Builder simpleMessageDialog(@NonNull Context context, String titleString, String message, int closeButtonStringId, DialogInterface.OnClickListener onCloseButtonClick) {
        return new AlertDialog.Builder(context)
                .setTitle(titleString)
                .setMessage(message)
                .setPositiveButton(closeButtonStringId, onCloseButtonClick);
    }

    private static AlertDialog.Builder simpleRequestErrorDialog(@NonNull Context context, @NonNull String error, int titleStringId, int defaultMessageStringId, int retryButtonStringId, int closeButtonStringId, @Nullable HashMap<String, Integer> requestErrorAndCaseMassageMap, @NonNull DialogInterface.OnClickListener onRetryButtonClick) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context)
                .setTitle(titleStringId)
                .setPositiveButton(closeButtonStringId, null);
        boolean addRetryButton = true;
        int requestErrorCaseStringId = -1;
        if (requestErrorAndCaseMassageMap != null) {
            for (String key : requestErrorAndCaseMassageMap.keySet()) {
                Log.d("AlertDialog", "error: " + (error == null ? "null" : error));
                Log.d("AlertDialog", "key: " + (key == null ? "null" : error));
                if (error.contains(key)) {
                    addRetryButton = false;
                    requestErrorCaseStringId = requestErrorAndCaseMassageMap.get(key);
                }
            }
        }
        if (addRetryButton) {
            dialogBuilder.setNeutralButton(retryButtonStringId, onRetryButtonClick);
            dialogBuilder.setMessage(defaultMessageStringId);
        } else {
            dialogBuilder.setMessage(requestErrorCaseStringId);
        }
        return dialogBuilder;
    }

    private static final String DEFAULT_DOWNLOAD_DIALOG_TEXT = "Downloading...";
    private static final int TEXT_TOP_MARGIN_DP = 20;
    private static final int DOWNLOAD_DIALOG_SPACING = 50;

    /**
     * Download progress dialog. For showing when some background activity.
     * @param context Context
     * @param downloadingTextRes Text what typed below progress bar.
     * @return AlertDialog
     */
    public static @NonNull
    AlertDialog downloadDialog(@NonNull Context context, int downloadingTextRes) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams progressLayoutParam = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        progressLayoutParam.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setId(android.R.id.progress);
        relativeLayout.addView(progressBar, progressLayoutParam);
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, android.R.color.black));
        if (downloadingTextRes == EMPTY_RES) {
            textView.setText(DEFAULT_DOWNLOAD_DIALOG_TEXT);
        } else {
            textView.setText(downloadingTextRes);
        }
        RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.topMargin = convertFromDpToPx(context, TEXT_TOP_MARGIN_DP);
        textViewLayoutParams.addRule(RelativeLayout.BELOW, android.R.id.progress);
        textViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
        relativeLayout.addView(textView, textViewLayoutParams);
        int dialogSpacing = convertFromDpToPx(context, DOWNLOAD_DIALOG_SPACING);
        return new AlertDialog.Builder(context)
                .setView(relativeLayout, dialogSpacing, dialogSpacing, dialogSpacing, dialogSpacing)
                .setCancelable(false)
                .create();
    }

    private static int convertFromDpToPx(Context context, int dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static AlertDialog singleChoiceDialog(@NonNull Context context, int titleStringId, @NonNull List<String> checkBoxItemsText, @Nullable String checkedItemText, @NonNull DialogInterface.OnClickListener onClickListener) {
        return new AlertDialog.Builder(context)
                .setTitle(titleStringId)
                .setSingleChoiceItems(convertListToCharSequenceArray(checkBoxItemsText), getItemByString(checkBoxItemsText, checkedItemText), onClickListener)
                .create();
    }

    private static CharSequence[] convertListToCharSequenceArray(List<String> list) {
        CharSequence[] charSequences = new CharSequence[list.size()];
        for (int i=0; i<list.size(); i++) {
            charSequences[i] = list.get(i);
        }
        return charSequences;
    }

    private static int getItemByString(List<String> list, String checkedItemText) {
        int item = -1;
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).equals(checkedItemText)) {
                item = i;
            }
        }
        return item;
    }

    public static AlertDialog twoButtonsDialog(@NonNull Context context, int titleStringId, int messageStringId, int positiveButtonTextStringId, DialogInterface.OnClickListener onPositiveButtonClick, int negativeButtonStringId, DialogInterface.OnClickListener onNegativeButtonClickListener) {
        return new AlertDialog.Builder(context)
                .setTitle(titleStringId)
                .setMessage(messageStringId)
                .setPositiveButton(positiveButtonTextStringId, onPositiveButtonClick)
                .setNegativeButton(negativeButtonStringId, onNegativeButtonClickListener)
                .create();
    }

    @NonNull public static AlertDialog errorMessageDialog(@NonNull Context context, @NonNull String title, @NonNull String message, @NonNull String closeButtonText, @Nullable DialogInterface.OnClickListener onCloseButtonClick, @NonNull String retryButtonText, @Nullable DialogInterface.OnClickListener onRetryButtonClick) {
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(closeButtonText, onCloseButtonClick)
                .setNegativeButton(retryButtonText, onRetryButtonClick)
                .create();
    }

    @NonNull public static AlertDialog errorMessageDialog(@NonNull Context context, int titleStringId, @NonNull String message, int closeButtonTextStringId, @Nullable DialogInterface.OnClickListener onCloseButtonClick, int retryButtonTextStringId, @Nullable DialogInterface.OnClickListener onRetryButtonClick) {
        return errorMessageDialog(context, context.getString(titleStringId), message, context.getString(closeButtonTextStringId), onCloseButtonClick, context.getString(retryButtonTextStringId), onRetryButtonClick);
    }

}
