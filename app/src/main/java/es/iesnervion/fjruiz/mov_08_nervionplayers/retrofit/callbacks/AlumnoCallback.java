package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.callbacks;

import android.content.Context;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces.ICAlumno;
import es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces.ICToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fjruiz on 14/02/17.
 */

public class AlumnoCallback implements Callback<Alumno> {


    private ICAlumno enviador;
    private Context miContexto;

    public AlumnoCallback(Context miContexto){
        this.miContexto=miContexto;
        if (miContexto instanceof ICAlumno) {
            enviador = (ICAlumno) miContexto;
        } else {
            throw new RuntimeException(miContexto.toString()
                    + " must implement ICAlumno");
        }
    }

    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */
    @Override
    public void onResponse(Call<Alumno> call, Response<Alumno> response) {
        enviador.getAlumnoAceptado(response);
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<Alumno> call, Throwable t) {
        enviador.getAlumnoRechazado();
    }
}
