package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks;

import android.content.Context;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces.ICAlumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces.ICToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by javi on 5/03/17.
 */

public class AlumnoPostCallback implements Callback<Alumno> {


    private ICAlumno enviador;
    private Context miContexto;

    public AlumnoPostCallback(Context miContexto){
        this.miContexto=miContexto;
        if (miContexto instanceof ICToken) {
            enviador = (ICAlumno) miContexto;
        } else {
            throw new RuntimeException(miContexto.toString()
                    + " must implement ICAlumno");
        }
    }
    @Override
    public void onResponse(Call<Alumno> call, Response<Alumno> response) {
        enviador.postAlumnoAceptado(response);
    }

    @Override
    public void onFailure(Call<Alumno> call, Throwable t) {
        enviador.postAlumnoRechazado();
    }
}
