package com.bvblogic.arandroid.api.service;

import com.bvblogic.arandroid.api.model.UserApi;
import com.bvblogic.arandroid.api.model.core.Head;

import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

/**
 * Created by Forfend on 14.04.2018.
 */

public interface UserService {

    @GET("get")
    Observable<Head<UserApi>> getUser(@Query("name") String name);


}
