package com.globant.equattrocchio.domain.service;

import io.reactivex.Observer;

public interface ImagesServices {
    void getLatestImages(final Observer<String> observer);
}
