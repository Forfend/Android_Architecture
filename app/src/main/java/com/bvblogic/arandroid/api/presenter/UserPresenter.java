package com.bvblogic.arandroid.api.presenter;

import com.bvblogic.arandroid.api.core.BaseView;
import com.bvblogic.arandroid.api.model.UserApi;
import com.bvblogic.arandroid.api.networking.NetworkUser;
import com.bvblogic.arandroid.api.networking.core.Service;
import com.bvblogic.arandroid.api.networking.error.NetworkError;
import com.bvblogic.arandroid.api.presenter.core.Presenter;

/**
 * Created by Forfend on 14.04.2018.
 */

public class UserPresenter extends Presenter<NetworkUser, UserApi> {

    public UserPresenter(NetworkUser service, BaseView<UserApi> baseView) {
        super(service, baseView);
    }

    public void getUser(String user) {
        baseView.showWait();
        disposable.add(service.getUser(user, new Service.Callback<UserApi>() {
            @Override
            public void OnSuccess(UserApi userApi) {
                baseView.closeWait();
                baseView.OnSuccess(userApi);
                onStop();
            }

            @Override
            public void OnError(NetworkError networkError) {
                baseView.closeWait();
                onStop();
            }
        }));

    }

}