package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit;


import android.content.Context;

import butterknife.BindString;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks.AlumnoPostCallback;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks.TokenCallback;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces.AlumnoInterface;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces.TokenInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiRetrofit {
    private Retrofit miRetrofit;
    private Context miContexto;
    //TODO CAmbiar cadena
    @BindString(R.string.nombreApi) String nombreApi;
    public MiRetrofit(Context miContexto){
        this.miContexto=miContexto;
        miRetrofit=new Retrofit.Builder().baseUrl("https://cambiar.es")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public void getToken(String auth){
        TokenInterface service=miRetrofit.create(TokenInterface.class);
        TokenCallback tc=new TokenCallback(this.miContexto);
        service.getToken(auth).enqueue(tc);
    }

    public void postAlumno(Alumno alumno){
        AlumnoInterface service=miRetrofit.create(AlumnoInterface.class);
        AlumnoPostCallback apc=new AlumnoPostCallback(this.miContexto);
        service.postAlumno().enqueue(apc);
    }

}
