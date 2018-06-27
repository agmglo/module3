package com.globant.equattrocchio.domain.service;

import com.globant.equattrocchio.domain.response.Result;

import io.reactivex.Observer;

public interface ImagesServices {

    void getLatestImages(Observer<Result> observer);
}
