package br.com.teste.call.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by flip_novidade on 11/24/16.
 */

public class Utils {
    public static  boolean isNetworkConnected(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
