package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit.restInterfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface TokenInterface {
    @GET("token")
    Call<Void> getToken(@Header("Authorization") String auth);
}
