package com.bvblogic.arandroid.api.core;

/**
 * Created by Forfend on 14.04.2018.
 */

public interface BaseView<T> {

    void OnFailure(String error);

    void OnSuccess(T t);

    void showWait();

    void closeWait();

}
