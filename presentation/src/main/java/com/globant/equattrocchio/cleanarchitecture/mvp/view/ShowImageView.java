package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.domain.response.Image;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowImageView extends DialogFragmentView {

    private final Context context;
    @BindView(R.id.text_id) TextView tvId;
    @BindView(R.id.text_large_url) TextView tvLargeUrl;
    @BindView(R.id.text_url) TextView tvUrl;
    @BindView(R.id.text_copyright) TextView tvCopyright;
    @BindView(R.id.text_site) TextView tvSite;
    @BindView(R.id.image) ImageView imageView;
    @BindView(R.id.progress_image) ProgressBar progressBarImage;
    @BindView(R.id.progress_text) ProgressBar progressBarText;

    public ShowImageView(DialogFragment dialogFragmentView) {
        super(dialogFragmentView);
        this.context = dialogFragmentView.getActivity();
        ButterKnife.bind(this, dialogFragmentView.getView());
    }

    public void setContent(Image image) {
        Picasso.with(context)
                .load(image.getUrl())
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBarImage.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        showError();
                    }
                });
        tvId.setText(context.getString(R.string.msg_id, image.getImageId()));
        tvUrl.setText(context.getString(R.string.msg_url, image.getUrl()));
        tvLargeUrl.setText(context.getString(R.string.msg_large_url, image.getLargeUrl()));
        tvCopyright.setText(context.getString(R.string.msg_copyright, image.getCopyright()));
        tvSite.setText(context.getString(R.string.msg_site, image.getSite()));
        progressBarText.setVisibility(View.GONE);
    }

    public void showError() {
        tvId.setText(context.getString(R.string.connection_error));
    }
}
