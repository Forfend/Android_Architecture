package com.bvblogic.arandroid.api.networking.module;

import com.bvblogic.arandroid.api.networking.NetworkUser;
import com.bvblogic.arandroid.api.service.UserService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Forfend on 14.04.2018.
 */

@Module
public class NetworkModule {

    private File cacheFile;
    private String url;

    public NetworkModule(File cacheFile, String url) {
        this.cacheFile = cacheFile;
        this.url = url;
    }

    @Provides
    @Singleton
    Retrofit providerCall() {
        Cache cache = null;
        try {
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        }catch (Exception e){
            e.printStackTrace();
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request origin = chain.request();
                    Request request = origin.newBuilder()
                            .header("Content-Type","application/json")
                            .header("Cache-Control","max-age=432000")
                            .removeHeader("Pragma")
                            .build();

                    Response response = chain.proceed(request);
                    response.cacheResponse();
                    return response;
                })
                .cache(cache)
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120,TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public UserService providesUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }

    @Provides
    @Singleton
    public NetworkUser providersNetworkUser(UserService userService){
        return new NetworkUser(userService);
    }

}
