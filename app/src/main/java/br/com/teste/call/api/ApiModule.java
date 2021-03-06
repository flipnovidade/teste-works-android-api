package br.com.teste.call.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.io.File;
import java.util.Date;

import br.com.teste.call.AppDelegate;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiModule {

    public Gson providesGson() {

        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();
    }

    public Retrofit providesRestAdapter(Gson gson) {

        long SIZE_OF_CACHE = 10 * 1024 * 1024; // 10 MiB
        Cache c = new Cache(new File(AppDelegate.getInstance().getApplicationContext().getCacheDir(), "http"), SIZE_OF_CACHE);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().cache(c).addInterceptor(interceptor).addNetworkInterceptor(new CachingControlInterceptor()).build();

        return new Retrofit.Builder()
                //.baseUrl("http://api.mycubomob.com.br/v1")
                .baseUrl( "https://api.dribbble.com/" )
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public API provideService(Retrofit adapter) {
        return adapter.create(API.class);
    }

    public static API service() {
        ApiModule module = new ApiModule();
        Gson gson = module.providesGson();
        Retrofit adapter = module.providesRestAdapter(gson);
        return module.provideService(adapter);
    }

}
