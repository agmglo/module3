package com.globant.equattrocchio.cleanarchitecture;

import android.view.View;

import com.globant.equattrocchio.cleanarchitecture.mvp.presenter.ImagesPresenter;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.ImagesView;
import com.globant.equattrocchio.domain.GetLatestImagesUseCase;
import com.globant.equattrocchio.domain.response.Image;
import com.globant.equattrocchio.domain.response.Result;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ImagesPresenterTest {
    @Mock private Result result;
    private ImagesPresenter presenter;
    @Mock private ImagesView view;
    @Mock private GetLatestImagesUseCase getLatestImagesUseCase;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new ImagesPresenter(view, getLatestImagesUseCase);
    }

    @Test
    public void testCallService() {
        presenter.onCallServiceButtonPressed();
        Mockito.verify(view).setProgressVisibility(View.VISIBLE);
    }

    @Test
    public void testCallServiceFAB() {
        presenter.onCallServiceFABPressed();
        Mockito.verify(view).setProgressVisibility(View.VISIBLE);
    }

    @Test
    public void testLoadImages() {
        result = getMockResult();
        presenter.loadImages(result);
        Mockito.verify(view).setProgressVisibility(View.GONE);
    }

    @Test
    public void testShowError() {
        presenter.showError();
        Mockito.verify(view).setProgressVisibility(View.GONE);
    }

    @Test
    public void testSaveImages() {
        result = getMockResult();
        presenter.saveImages(result);
        Mockito.verify(view).setProgressVisibility(View.GONE);
    }

    private Result getMockResult() {
        Result result = new Result();
        Image image = new Image();
        image.setCopyright("copy");
        image.setImageId(182394);
        image.setLargeUrl("large-url");
        image.setUrl("url");
        image.setSite("site");
        List<Image> list = new ArrayList<>();
        list.add(image);
        list.add(image);
        result.setImages(list);
        return result;
    }
}
