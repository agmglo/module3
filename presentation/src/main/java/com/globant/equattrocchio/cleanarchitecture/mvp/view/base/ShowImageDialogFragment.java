package com.globant.equattrocchio.cleanarchitecture.mvp.view.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.globant.equattrocchio.cleanarchitecture.R;
import com.globant.equattrocchio.cleanarchitecture.mvp.presenter.ShowImagePresenter;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.ShowImageView;
import com.globant.equattrocchio.data.GetImageServicesImpl;
import com.globant.equattrocchio.domain.GetImageUseCase;

public class ShowImageDialogFragment extends DialogFragment {
    private static final String ARGUMENT_IMAGE = "argument_extra";
    private Integer image;
    private ShowImagePresenter presenter;
    private GetImageUseCase getImageUseCase;

    public static ShowImageDialogFragment newInstance(Integer id) {
        ShowImageDialogFragment fragment = new ShowImageDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_IMAGE, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        image = getArguments().getInt(ARGUMENT_IMAGE);
        if (image != null) {
            getImageUseCase = new GetImageUseCase(new GetImageServicesImpl(), image);
            presenter = new ShowImagePresenter(new ShowImageView(this), getImageUseCase);
            presenter.init(image);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NO_TITLE, R.style.Theme_AppCompat_Light_NoActionBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_show_image, container, false);
    }
}
