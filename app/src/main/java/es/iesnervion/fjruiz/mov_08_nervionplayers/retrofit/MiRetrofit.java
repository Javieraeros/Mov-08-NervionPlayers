package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit;


import android.content.Context;

import butterknife.BindString;
import es.iesnervion.fjruiz.mov_08_nervionplayers.R;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks.AlumnoCallback;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks.TokenCallback;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces.AlumnoInterface;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces.TokenInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MiRetrofit {
    private Retrofit miRetrofit;
    private Context miContexto;
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

    /**
     *Método que nos devuelve toda la información de un alumno de nuestra api
     * @param auth token de alumno
     * @param name podrá ser el alias o el correo
     * @param password contraseña del alumno
     */
    public void getAlumno(String auth,String name,String password){
        AlumnoInterface service=miRetrofit.create(AlumnoInterface.class);
        AlumnoCallback ac=new AlumnoCallback(this.miContexto);
        service.getAlumno(auth,name,password).enqueue(ac);
    }
}
