package com.globant.equattrocchio.data;

import com.globant.equattrocchio.data.service.api.SplashBaseApi;
import com.globant.equattrocchio.domain.response.Image;
import com.globant.equattrocchio.domain.service.ShowImageServices;

import io.reactivex.Observer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetImageServicesImpl implements ShowImageServices {
    private static final String URL = "http://splashbase.co/";

    @Override
    public void getImage(final Observer<Image> observer, Integer id) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(URL).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        SplashBaseApi api = retrofit.create(SplashBaseApi.class);
        Call<Image> call = api.getImage(id);
        call.enqueue(new Callback<Image>() {
            @Override
            public void onResponse(Call<Image> call, Response<Image> response) {
                observer.onNext(response.body());
            }

            @Override
            public void onFailure(Call<Image> call, Throwable t) {
                observer.onError(t);
            }
        });
    }
}
