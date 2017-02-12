package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit;


import retrofit2.Response;

public interface ICToken {
    //void cuandoAcabe(Persona[] miArray);

    void getTokenAceptado(Response<Void> response);
    void getTokenRechazado();
}
