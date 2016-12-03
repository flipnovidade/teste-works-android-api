package br.com.teste.call;

import android.annotation.SuppressLint;
import android.app.Application;

import br.com.teste.call.utils.LogUtils;

public class AppDelegate extends Application {
    private static final String TAG = AppDelegate.class.getSimpleName();
    private static AppDelegate appDelegate;

    @SuppressLint("CommitPrefEdits")
    public void onCreate() {
        super.onCreate();
        appDelegate = this;
        LogUtils.i(TAG, "AppDelegate Inicializado!");

    }

    public static AppDelegate getInstance() {
        return appDelegate;
    }

}
