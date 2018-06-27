package com.globant.equattrocchio.cleanarchitecture.util.bus.observers;

public abstract class ImageClickObserver extends BusObserver<ImageClickObserver.ImagePressed> {
    public ImageClickObserver() {
        super(ImagePressed.class);
    }

    public static class ImagePressed {
        private Integer id;

        public ImagePressed(Integer id){
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}