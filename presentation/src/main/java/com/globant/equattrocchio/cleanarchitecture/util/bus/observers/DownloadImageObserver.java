package com.globant.equattrocchio.cleanarchitecture.util.bus.observers;

public abstract class DownloadImageObserver extends BusObserver<DownloadImageObserver.DownloadImage> {
    public DownloadImageObserver() {
        super(DownloadImage.class);
    }

    public static class DownloadImage {
        /*private Integer id;

        public DownloadImage(Integer id){
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }*/
    }
}