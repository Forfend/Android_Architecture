package com.bvblogic.arandroid.api.networking.error;

import java.io.IOException;

import retrofit2.HttpException;

/**
 * Created by Forfend on 14.04.2018.
 */

public class NetworkError extends Throwable {

    private final Throwable error;

    public NetworkError(Throwable error) {
        super(error);
        this.error = error;
    }

    public String getMessage(){
        return error.getMessage();
    }

    public String getAppErrorMessage(){
        if (this.error instanceof IOException)
            return "not internet connection";
        if ((this.error instanceof HttpException))
            return "Error";
        return "Base Error";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NetworkError that = (NetworkError) o;

        return error != null ? error.equals(that.error) : that.error == null;
    }

    @Override
    public int hashCode() {
        return error != null ? error.hashCode() : 0;
    }
}
