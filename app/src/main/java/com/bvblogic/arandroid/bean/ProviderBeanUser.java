package com.bvblogic.arandroid.bean;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bvblogic.arandroid.activity.core.BaseActivity;
import com.bvblogic.arandroid.adapter.user.UserAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Forfend on 31.03.2018.
 */

@EBean
public class ProviderBeanUser {

    @RootContext
    BaseActivity baseActivity;

    @Bean
    UserAdapter userAdapter;

    @ViewById
    RecyclerView rv;

    @AfterViews
    public void initUserAdapter(){
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(baseActivity));
        rv.setAdapter(userAdapter);
    }
}
