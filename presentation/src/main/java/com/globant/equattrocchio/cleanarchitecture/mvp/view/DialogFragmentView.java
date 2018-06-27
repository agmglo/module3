package com.globant.equattrocchio.cleanarchitecture.mvp.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

public class DialogFragmentView {
    private WeakReference<DialogFragment> fragmentWeakReference;

    public DialogFragmentView(DialogFragment dialogFragmentView) {
        fragmentWeakReference = new WeakReference<>(dialogFragmentView);
    }

    @Nullable
    public FragmentActivity getActivity() {
        return fragmentWeakReference.get().getActivity();
    }

    @Nullable
    public Context getContext() {
        return getContext();
    }

    @Nullable
    public android.app.FragmentManager getFragmentManager() {
        Activity fragment = getActivity();
        return (fragment != null) ? fragment.getFragmentManager() : null;
    }
}
