package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by javi on 5/03/17.
 */

public interface AlumnoInterface {
    @POST("alumno")
    Call<Alumno> postAlumno();
}
