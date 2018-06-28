package com.globant.equattrocchio.domain;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

public class DataBaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
