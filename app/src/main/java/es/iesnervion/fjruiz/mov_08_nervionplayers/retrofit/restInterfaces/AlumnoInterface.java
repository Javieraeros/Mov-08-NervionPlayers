package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces;

import java.util.List;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AlumnoInterface {
    //Todo cambiar
    @GET("api/Alumno")
    Call<Alumno> getAlumno(@Header("Authorization") String auth,String correo,String password);
}
