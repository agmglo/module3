package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.adapter.ImagesAdapter;
import com.globant.equattrocchio.cleanarchitecture.util.bus.RxBus;
import com.globant.equattrocchio.cleanarchitecture.util.bus.observers.CallServiceButtonObserver;
import com.globant.equattrocchio.domain.response.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ImagesView extends ActivityView {

    private final Context context;
    @BindView(R.id.tv_incoming_json) TextView tvlabel;
    @BindView(R.id.recycler_images) RecyclerView recyclerImages;

    public ImagesView(AppCompatActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
        this.context = getContext();
    }

    public void loadRecycler(Result result) {
        tvlabel.setVisibility(View.GONE);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerImages.setLayoutManager(mLayoutManager);
        recyclerImages.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        recyclerImages.setAdapter(new ImagesAdapter(result));
    }

    @OnClick(R.id.btn_call_service)
    public void callServiceBtnPressed() {
        RxBus.post(new CallServiceButtonObserver.CallServiceButtonPressed());
    }

    public void showError() {
        tvlabel.setVisibility(View.VISIBLE);
        tvlabel.setText(R.string.connection_error);
    }
}
