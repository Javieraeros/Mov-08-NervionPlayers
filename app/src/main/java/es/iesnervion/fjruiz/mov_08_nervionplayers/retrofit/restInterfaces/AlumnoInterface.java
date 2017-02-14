package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces;

import java.util.List;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by fjruiz on 14/02/17.
 */

public interface AlumnoInterface {
    //Todo cambiar
    @GET("api/Alumno")
    Call<Alumno> getAlumno(@Header("Authorization") String auth);
}
