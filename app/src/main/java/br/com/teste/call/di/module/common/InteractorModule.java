package br.com.teste.call.di.module.common;

import api.ApiInteractor;
import api.ApiInteractorImpl;
import br.com.teste.call.api.API;
import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public ApiInteractor provideApiInteractor(API api) {
        return new ApiInteractorImpl(api);
    }

}