package com.relam.myrelamdatabase.app;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by pritesh on 3/4/2017.
 */

public class YoutubeClient {

    public YoutubeClient() {
    }

    public YoutubeApi youtubeApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.YOUTUBE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(YoutubeApi.class);
    }
}
