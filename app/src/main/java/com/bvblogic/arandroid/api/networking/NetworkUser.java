package com.bvblogic.arandroid.api.networking;

import com.bvblogic.arandroid.api.model.UserApi;
import com.bvblogic.arandroid.api.model.core.Head;
import com.bvblogic.arandroid.api.networking.core.Service;
import com.bvblogic.arandroid.api.networking.error.NetworkError;
import com.bvblogic.arandroid.api.service.UserService;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Forfend on 14.04.2018.
 */

public class NetworkUser extends Service<UserService> {

    public NetworkUser(UserService networkService) {
        super(networkService);
    }

    public Disposable getUser(String userName, Callback<UserApi> headCallback){
        return networkService.getUser(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Head<UserApi>>() {

                    @Override
                    public void onNext(Head<UserApi> userApiHead) {
                        headCallback.OnSuccess(userApiHead.getT());
                    }

                    @Override
                    public void onError(Throwable e) {
                        headCallback.OnError(new NetworkError(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        }
    }

