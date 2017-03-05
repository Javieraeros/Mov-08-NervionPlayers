package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces;

import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import retrofit2.Response;

/**
 * Created by javi on 5/03/17.
 */

public interface ICAlumno {
    void postAlumnoAceptado(Response<Alumno> response);
    void postAlumnoRechazado();
}
