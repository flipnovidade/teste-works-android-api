package br.com.teste.call.api;

import java.util.List;

import br.com.teste.call.model.Shots;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallApi {

    private CallOnListener callOnListener;

    public interface CallOnListener{
        void ResponseOK(List<Shots> objectList);
        void ResponseFail();
    }

    public CallApi(CallOnListener callOnListener) {
        this.callOnListener = callOnListener;
    }

    public void callApi(String token, String page, String perPage){

        Call<List<Shots>> objectCall = ApiModule.service().sendRegister(token, page, perPage);
        objectCall.enqueue(new Callback<List<Shots>>() {
            @Override
            public void onResponse(Call<List<Shots>> call, Response<List<Shots>> response) {
                if( response.code() == 200){

                        if(response.body() != null && response.body().size() > 0 ){
                            callOnListener.ResponseOK((List<Shots>) response.body());
                        }else{
                            callOnListener.ResponseFail();
                        }

                }else{
                    callOnListener.ResponseFail();
                }
            }

            @Override
            public void onFailure(Call<List<Shots>> call, Throwable t) {
                callOnListener.ResponseFail();
            }
        });


    }

}
