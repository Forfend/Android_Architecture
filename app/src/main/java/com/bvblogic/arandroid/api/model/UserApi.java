package com.bvblogic.arandroid.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Forfend on 14.04.2018.
 */

public class UserApi {

    @SerializedName("name")
    @Expose
    private String name;

    public UserApi() {
    }

    public UserApi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
