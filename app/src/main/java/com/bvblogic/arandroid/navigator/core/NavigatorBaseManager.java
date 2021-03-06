package com.bvblogic.arandroid.navigator.core;

import com.bvblogic.arandroid.activity.core.BaseActivity;
import com.bvblogic.arandroid.fragment.core.BaseFragment;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Forfend on 24.03.2018.
 */

@EBean
public abstract class NavigatorBaseManager {

    @RootContext
    protected BaseActivity baseActivity; // new BaseActivity();

    public abstract Manager getMainManager(BaseFragment baseFragment);

}
