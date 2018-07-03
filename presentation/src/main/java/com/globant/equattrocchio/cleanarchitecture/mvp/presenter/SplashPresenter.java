package com.globant.equattrocchio.cleanarchitecture.mvp.presenter;

import com.globant.equattrocchio.cleanarchitecture.mvp.view.SplashView;

public class SplashPresenter {
    private SplashView view;

    public SplashPresenter(SplashView view) {
        this.view = view;
    }

    public void init() {
        view.rotateImage();
    }
}
