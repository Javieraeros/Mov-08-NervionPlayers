package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit;


import android.content.Context;

import butterknife.BindString;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks.TokenCallback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiRetrofit {
    private Retrofit miRetrofit;
    private RestInterface service;
    private Context miContexto;
    private @BindString(R.string.nombreApi) String nombreApi;
    public MiRetrofit(Context miContexto){
        this.miContexto=miContexto;
        miRetrofit=new Retrofit.Builder().baseUrl(nombreApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service=miRetrofit.create(RestInterface.class);
    }

    public void getToken(String auth){
        TokenCallback tc=new TokenCallback(this.miContexto);
        service.getToken(auth).enqueue(tc);
    }
}
