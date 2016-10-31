package com.coulcod.recipescatalog.entity.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

public class InternetConnectionUtil {

    private static InternetConnectionUtil instance;

    public static void init(@NonNull Context context) {
        instance = new InternetConnectionUtil(context);
    }

    public static InternetConnectionUtil getInstance() {
        return instance;
    }

    @NonNull
    private final Context context;

    private InternetConnectionUtil(@NonNull Context context) {
        this.context = context;
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
