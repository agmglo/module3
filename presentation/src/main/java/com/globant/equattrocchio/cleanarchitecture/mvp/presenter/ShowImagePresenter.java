package com.globant.equattrocchio.cleanarchitecture.mvp.presenter;

import android.app.Activity;

import com.globant.equattrocchio.cleanarchitecture.mvp.view.ShowImageView;
import com.globant.equattrocchio.cleanarchitecture.util.bus.RxBus;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.DownloadImageObserver;
import com.globant.equattrocchio.data.GetImageServicesImpl;
import com.globant.equattrocchio.domain.GetImageUseCase;
import com.globant.equattrocchio.domain.response.Image;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

public class ShowImagePresenter {
    private ShowImageView view;
    private GetImageUseCase getImageUseCase;

    public ShowImagePresenter(ShowImageView view, GetImageUseCase getImageUseCase) {
        this.view = view;
        this.getImageUseCase = getImageUseCase;
    }

    public void init() {
        register();
        RxBus.post(new DownloadImageObserver.DownloadImage());
    }

    private void onCallService() {
        getImageUseCase.execute(new DisposableObserver<Image>() {
            @Override
            public void onNext(@NonNull Image result) {
                showInfo(result);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                view.showError();
            }

            @Override
            public void onComplete() {
                new GetImageServicesImpl().getImage(null, null);
            }
        }, null);
    }

    public void showInfo(Image image) {
        view.setContent(image);
    }

    public void register() {
        Activity activity = view.getActivity();
        if (activity == null) {
            return;
        }
        RxBus.subscribe(activity, new DownloadImageObserver() {
            @Override
            public void onEvent(DownloadImageObserver.DownloadImage event) {
                onCallService();
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
