package br.com.teste.call.di.module.common;

import api.ApiInteractor;
import api.ApiInteractorImpl;
import br.com.teste.call.api.API;
import br.com.teste.call.api.ApiModule;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class InteractorModule {

    @Provides
    public ApiInteractor provideApiInteractor(ApiModule api, Retrofit adapter ) {
        return new ApiInteractorImpl(api, adapter);
    }

}