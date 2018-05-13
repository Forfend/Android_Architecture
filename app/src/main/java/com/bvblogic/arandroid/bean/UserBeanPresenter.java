package com.bvblogic.arandroid.bean;

import android.widget.Toast;

import com.bvblogic.arandroid.api.model.UserApi;
import com.bvblogic.arandroid.api.presenter.UserPresenter;
import com.bvblogic.arandroid.bean.core.UserBean;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EBean;

/**
 * Created by Forfend on 17.04.2018.
 */

@EBean
public class UserBeanPresenter extends UserBean{

    @Override
    public void init() {
        super.init();
        getUserDeps().inject(this);
    }

    @AfterViews
    public void getUser(){
        new UserPresenter(networkUser,this).getUser("Oleg");
    }

    @Override
    public void OnSuccess(UserApi userApi) {
        Toast.makeText(baseActivity, userApi.getName(), Toast.LENGTH_SHORT).show();
    }
}
