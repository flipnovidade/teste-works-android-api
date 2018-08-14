package br.com.teste.call.di.module.common;

import android.content.Context;
import br.com.teste.call.AppDelegate;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private AppDelegate app;

    public AppModule(AppDelegate app) {
        this.app = app;
    }

    @Provides
    AppDelegate provideApp() {
        return app;
    }

    @Provides
    public Context provideContext(AppDelegate app) {
        return app.getApplicationContext();
    }

}
