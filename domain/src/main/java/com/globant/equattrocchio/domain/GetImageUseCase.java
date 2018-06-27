package com.globant.equattrocchio.domain;

import com.globant.equattrocchio.domain.response.Image;
import com.globant.equattrocchio.domain.service.ShowImageServices;

import io.reactivex.observers.DisposableObserver;

public class GetImageUseCase extends UseCase<Image, Void> {
    private Integer id;
    private ShowImageServices imagesServices;

    public GetImageUseCase(ShowImageServices imagesServices, Integer id) {
        super();
        this.id = id;
        this.imagesServices = imagesServices;
    }

    @Override
    void buildUseCaseObservable(DisposableObserver<Image> observer, Void aVoid) {
        imagesServices.getImage(observer, id);
    }
}
