package com.bvblogic.arandroid.bean.core;

import com.bvblogic.arandroid.activity.core.BaseActivity;
import com.bvblogic.arandroid.api.core.BaseView;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Forfend on 17.04.2018.
 */

@EBean
public abstract class Bean<T> implements BaseView<T>{

    @RootContext
    public BaseActivity baseActivity;


    @Override
    public void OnFailure(String error) {

    }

    @Override
    public void OnSuccess(T t) {

    }

    @Override
    public void showWait() {

    }

    @Override
    public void closeWait() {

    }
}
