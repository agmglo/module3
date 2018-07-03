package com.globant.equattrocchio.cleanarchitecture.util.bus.observers;

public abstract class DownloadImageObserver extends BusObserver<DownloadImageObserver.DownloadImage> {
    public DownloadImageObserver() {
        super(DownloadImage.class);
    }

    public static class DownloadImage {
        //Do Nothing...
    }
}