package com.example.testapp.api;

import com.example.testapp.model.ModelValue;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("insert.php")
    Call<ModelValue> daftar(@Field("nim") String nim,
                            @Field("nama") String nama,
                            @Field("jurusan") String jurusan,
                            @Field("jk") String jk);

    @GET("view.php")
    Call<ModelValue> lihat();

    @FormUrlEncoded
    @POST("search.php")
    Call<ModelValue> cari(@Field("search") String search);
}
