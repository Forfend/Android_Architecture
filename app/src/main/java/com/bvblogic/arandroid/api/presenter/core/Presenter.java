package com.bvblogic.arandroid.api.presenter.core;

import com.bvblogic.arandroid.api.core.BaseView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Forfend on 14.04.2018.
 */

public abstract class Presenter<T, Y> {

    protected final T service;
    protected final BaseView<Y> baseView;
    protected CompositeDisposable disposable;

    public Presenter(T service, BaseView<Y> baseView) {
        this.service = service;
        this.baseView = baseView;
        this.disposable = new CompositeDisposable();
    }

    protected void onStop(){
        disposable.dispose();
    }
}
