package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.base.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashView extends ActivityView {

    private final Context context;
    @BindView(R.id.image) ImageView imageView;

    public SplashView(AppCompatActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
        this.context = getContext();
    }

    public void rotateImage() {
        imageView.animate().rotation(360).setDuration(2000).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

    private void startActivity() {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
