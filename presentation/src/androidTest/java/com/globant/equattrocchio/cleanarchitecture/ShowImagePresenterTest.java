package com.globant.equattrocchio.cleanarchitecture;

import com.globant.equattrocchio.cleanarchitecture.mvp.presenter.ShowImagePresenter;
import com.globant.equattrocchio.cleanarchitecture.mvp.view.ShowImageView;
import com.globant.equattrocchio.domain.GetImageUseCase;
import com.globant.equattrocchio.domain.response.Image;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ShowImagePresenterTest {
    private ShowImagePresenter presenter;
    @Mock private ShowImageView view;
    @Mock private GetImageUseCase getImageUseCase;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new ShowImagePresenter(view, getImageUseCase);
    }

    @Test
    public void testShowInfo() {
        Image image = getMockImage();
        presenter.showInfo(image);
        Mockito.verify(view).setContent(image);
    }

    private Image getMockImage() {
        Image image = new Image();
        image.setCopyright("copy");
        image.setImageId(182394);
        image.setLargeUrl("large-url");
        image.setUrl("url");
        image.setSite("site");
        return image;
    }
}
