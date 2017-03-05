package com.relam.myrelamdatabase.app;

import com.relam.myrelamdatabase.pojo.YoutubeModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pritesh on 3/4/2017.
 */

public interface YoutubeApi {

    @GET("youtube/v3/playlistItems")
    Observable<YoutubeModel> getYoutubeData(@Query("part") String snippet, @Query("maxResults") String maxResult,
                                            @Query("playlistId") String playlistId, @Query("key") String apiKey);

}
