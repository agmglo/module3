package com.globant.equattrocchio.cleanarchitecture.util.bus.observers;

public abstract class CallServiceFABObserver extends BusObserver<CallServiceFABObserver.CallServiceButtonPressed> {
    public CallServiceFABObserver() {
        super(CallServiceButtonPressed.class);
    }

    public static class CallServiceButtonPressed {
        //do nothing
    }
}