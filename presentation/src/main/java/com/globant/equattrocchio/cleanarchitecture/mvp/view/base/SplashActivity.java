package com.globant.equattrocchio.cleanarchitecture.mvp.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.presenter.SplashPresenter;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.SplashView;

public class SplashActivity extends AppCompatActivity {
    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(new SplashView(this));
        presenter.init();
    }
}
