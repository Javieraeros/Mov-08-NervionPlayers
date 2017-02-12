package es.iesnervion.fjruiz.mov_08_nervionplayers.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

interface RestInterface {
    @GET("token")
    Call<Void> getToken(@Header("Authorization") String auth);
}
