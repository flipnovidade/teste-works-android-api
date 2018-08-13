package br.com.teste.call;

import android.annotation.SuppressLint;
import android.app.Application;

import br.com.teste.call.di.AppModule;
import br.com.teste.call.utils.LogUtils;
import di.AppComponent;

public class AppDelegate extends Application {
    private static final String TAG = AppDelegate.class.getSimpleName();
    private static AppDelegate appDelegate;
    private static AppComponent component;

    @SuppressLint("CommitPrefEdits")
    public void onCreate() {
        super.onCreate();
        appDelegate = this;
        initComponent();

        LogUtils.i(TAG, "AppDelegate Inicializado!");
    }

    public static AppDelegate getInstance() {
        return appDelegate;
    }

    protected void initComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }
        component.inject(this);
    }

    public static AppComponent getComponent() {
        if (component == null && appDelegate != null) {
            component = DaggerAppComponent.builder().appModule(new AppModule(appDelegate)).build();
            component.inject(appDelegate);
        }
        return component;
    }

}
