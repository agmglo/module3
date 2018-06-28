package com.globant.equattrocchio.domain.service;

import com.globant.equattrocchio.domain.response.Result;

import io.reactivex.Observer;

public interface ImagesServices {
    void getLatestImages(final Observer<Result> observer);
}
