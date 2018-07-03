package com.globant.equattrocchio.cleanarchitecture.mvp.presenter;

import android.app.Activity;

import com.globant.equattrocchio.cleanarchitecture.mvp.view.ImagesView;
import com.globant.equattrocchio.cleanarchitecture.util.bus.RxBus;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.CallServiceButtonObserver;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.ImageClickObserver;
import com.globant.equattrocchio.data.ImagesServicesImpl;
import com.globant.equattrocchio.domain.GetLatestImagesUseCase;
import com.globant.equattrocchio.domain.response.Result;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class ImagesPresenter {
    private ImagesView view;
    private GetLatestImagesUseCase getLatestImagesUseCase;

    public ImagesPresenter(ImagesView view, GetLatestImagesUseCase getLatestImagesUseCase) {
        this.view = view;
        this.getLatestImagesUseCase = getLatestImagesUseCase;
    }

    public void loadImages(Result result) {
        view.loadRecycler(result);
    }

    private void onCallServiceButtonPressed() {
        getLatestImagesUseCase.execute(new DisposableObserver<Result>() {
            @Override
            public void onNext(@NonNull Result result) {
                loadImages(result);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError();
            }

            @Override
            public void onComplete() {
                new ImagesServicesImpl().getLatestImages(null);
            }
        }, null);
    }

    public void register() {
        Activity activity = view.getActivity();
        if (activity == null) {
            return;
        }
        RxBus.subscribe(activity, new CallServiceButtonObserver() {
            @Override
            public void onEvent(CallServiceButtonPressed event) {
                onCallServiceButtonPressed();
            }
        });
        RxBus.subscribe(activity, new ImageClickObserver() {
            @Override
            public void onEvent(ImagePressed event) {
                view.onItemClick(event.getId());
            }
        });
    }

    public void unregister() {
        Activity activity = view.getActivity();
        if (activity == null) {
            return;
        }
        RxBus.clear(activity);
    }
}
