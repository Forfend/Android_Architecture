package com.bvblogic.arandroid.adapter.user;

import android.view.ViewGroup;

import com.bvblogic.arandroid.activity.core.BaseActivity;
import com.bvblogic.arandroid.activity.core.ViewWrapper;
import com.bvblogic.arandroid.adapter.core.RecycleViewAdapterBase;
import com.bvblogic.arandroid.bean.finder.UserBeanFinder;
import com.bvblogic.arandroid.model.User;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by Forfend on 31.03.2018.
 */

@EBean
public class UserAdapter extends RecycleViewAdapterBase<User, UserItemView>{

    @RootContext
    BaseActivity baseActivity;

    @Bean
    UserBeanFinder userBeanFinder;

    @AfterViews
    public void initAdapter(){
        setItems(userBeanFinder.getUsers());
    }

    @Override
    protected UserItemView onCreateItemHolder(ViewGroup parent, int viewType) {
        return UserItemView_.build(baseActivity);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<UserItemView> holder, int position) {
        UserItemView view = holder.getView();
        User user = getItems().get(position);
        view.setTag(getItems().get(position));
        view.bind(user);
    }
}
