package com.globant.equattrocchio.domain;

import com.globant.equattrocchio.domain.response.Result;
import com.globant.equattrocchio.domain.service.ImagesServices;

import io.reactivex.observers.DisposableObserver;

public class GetLatestImagesUseCase extends UseCase<Result, Void> {
    private ImagesServices imagesServices;

    public GetLatestImagesUseCase(ImagesServices imagesServices) {
        super();
        this.imagesServices = imagesServices;
    }

    @Override
    void buildUseCaseObservable(final DisposableObserver<Result> observer, Void aVoid) {
        imagesServices.getLatestImages(observer);
    }
}
