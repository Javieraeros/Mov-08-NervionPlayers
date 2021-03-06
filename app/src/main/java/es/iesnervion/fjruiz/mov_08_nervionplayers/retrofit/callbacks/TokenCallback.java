package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks;

import android.content.Context;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces.ICToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by javi on 12/02/17.
 */

public class TokenCallback implements Callback<Alumno> {

    private ICToken enviador;
    private Context miContexto;

    public TokenCallback(Context miContexto){
        this.miContexto=miContexto;
        if (miContexto instanceof ICToken) {
            enviador = (ICToken) miContexto;
        } else {
            throw new RuntimeException(miContexto.toString()
                    + " must implement ICToken");
        }
    }

    @Override
    public void onResponse(Call<Alumno> call, Response<Alumno> response) {
        enviador.getTokenAceptado(response);
    }

    @Override
    public void onFailure(Call<Alumno> call, Throwable t) {
        enviador.getTokenRechazado();
    }
}
