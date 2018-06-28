package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.adapter.ImagesAdapter;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.base.ShowImageDialogFragment;
import com.globant.equattrocchio.cleanarchitecture.util.bus.RxBus;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.CallServiceButtonObserver;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.CallServiceFABObserver;
import com.globant.equattrocchio.domain.response.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImagesView extends ActivityView {

    private final Context context;
    @BindView(R.id.tv_incoming_json) TextView tvLabel;
    @BindView(R.id.recycler_images) RecyclerView recyclerImages;
    @BindView(R.id.fab) FloatingActionButton fab;

    public ImagesView(AppCompatActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
        this.context = getContext();
    }

    public void loadRecycler(Result result) {
        tvLabel.setVisibility(View.GONE);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerImages.setLayoutManager(mLayoutManager);
        recyclerImages.setAdapter(new ImagesAdapter(result));
    }

    @OnClick(R.id.btn_call_service)
    public void callServiceBtnPressed() {
        RxBus.post(new CallServiceButtonObserver.CallServiceButtonPressed());
    }

    @OnClick(R.id.fab)
    public void callServiceFABPressed() {
        RxBus.post(new CallServiceFABObserver.CallServiceButtonPressed());
    }

    public void showError() {
        tvLabel.setVisibility(View.VISIBLE);
        tvLabel.setText(R.string.connection_error);
    }

    public void onItemClick(Integer id) {
        ShowImageDialogFragment dialog = ShowImageDialogFragment.newInstance(id);
        dialog.show(getActivity().getSupportFragmentManager(), "show_image_dialog");
    }
}
