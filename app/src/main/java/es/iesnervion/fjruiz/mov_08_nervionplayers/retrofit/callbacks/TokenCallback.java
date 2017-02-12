package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks;

import android.content.Context;

import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.ICToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by javi on 12/02/17.
 */

public class TokenCallback implements Callback<Void> {

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
    public void onResponse(Call<Void> call, Response<Void> response) {
        //TODO recuperar cabecera Auth
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        //TODO mostrar toast. Si falla esto es porque el usuario/contraseña no son correctos
    }
}
