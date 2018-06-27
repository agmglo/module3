package com.globant.equattrocchio.domain.service;

import com.globant.equattrocchio.domain.response.Image;

import io.reactivex.Observer;

public interface ShowImageServices {
    void getImage(Observer<Image> observer, Integer id);
}
