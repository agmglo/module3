package com.globant.equattrocchio.data.service.api;

import com.globant.equattrocchio.domain.response.Image;
import com.globant.equattrocchio.domain.response.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SplashbaseApi {

    @GET("api/v1/images/latest")
    Call<Result> getImages();

    @GET("/api/v1/images/{id}")
    Call<Image> getImage(@Path("id") Integer id);
}
