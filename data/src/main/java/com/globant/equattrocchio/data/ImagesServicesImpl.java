package com.globant.equattrocchio.data;

import com.globant.equattrocchio.data.service.api.SplashBaseApi;
import com.globant.equattrocchio.domain.response.Result;
import com.globant.equattrocchio.domain.service.ImagesServices;

import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImagesServicesImpl implements ImagesServices {
    private static final String URL = "http://splashbase.co/";

    @Override
    public void getLatestImages(final Observer<Result> observer) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(URL).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        SplashBaseApi api = retrofit.create(SplashBaseApi.class);
        Call<Result> call = api.getImages();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                observer.onNext(response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                observer.onError(t);
            }
        });
    }
}
