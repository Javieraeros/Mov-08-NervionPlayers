package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import retrofit2.Response;

/**
 * Created by fjruiz on 14/02/17.
 */

public interface ICAlumno {
    void getAlumnoAceptado(Response<Alumno> response);
    void getAlumnoRechazado();
}
