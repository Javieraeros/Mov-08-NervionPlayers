package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.comunicatorInterfaces;


import es.iesnervion.fjruiz.mov_08_nervionplayers.model.Alumno;
import retrofit2.Response;

public interface ICToken {
    //void cuandoAcabe(Persona[] miArray);

    void getTokenAceptado(Response<Alumno> response);
    void getTokenRechazado();
}
