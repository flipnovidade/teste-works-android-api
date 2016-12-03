package br.com.teste.call.api;

import java.util.List;

import br.com.teste.call.AppConstant;
import br.com.teste.call.model.Shots;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    //@GET("/posts")
    @GET("/v1/users/"+ AppConstant.Dribbble.AccountAnother +"/shots")
    Call<List<Shots>> sendRegister(
            @Query("access_token") String access_token,
            @Query("page") String page,
            @Query("per_page") String perPage
    );

}
