package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.support.v4.app.DialogFragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.domain.response.Image;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowImageView extends DialogFragmentView {

    @BindView(R.id.text_id) TextView tvId;
    @BindView(R.id.text_large_url) TextView tvLargeUrl;
    @BindView(R.id.text_url) TextView tvUrl;
    @BindView(R.id.text_copyright) TextView tvCopyright;
    @BindView(R.id.text_site) TextView tvSite;
    @BindView(R.id.image) ImageView imageView;

    public ShowImageView(DialogFragment dialogFragmentView) {
        super(dialogFragmentView);
        ButterKnife.bind(this, dialogFragmentView.getView());
    }

    public void setContent(Image image) {
        Picasso.with(getActivity())
                .load(image.getUrl())
                .into(imageView);
        tvId.setText(String.valueOf(image.getId()));
        tvUrl.setText(image.getUrl());
        tvLargeUrl.setText(image.getLargeUrl());
        tvCopyright.setText(image.getCopyright());
        tvSite.setText(image.getSite());
    }


    public void showError() {

    }
}
