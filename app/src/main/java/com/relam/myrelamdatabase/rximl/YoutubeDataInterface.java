package com.relam.myrelamdatabase.rximl;

import com.relam.myrelamdatabase.pojo.YoutubeModel;

import rx.Observable;

/**
 * Created by pritesh on 3/4/2017.
 */

public interface YoutubeDataInterface {

    void onYoutubeDataFetchedComplete();
    void onYoutubeFetchError(String error);
    void onYotubeFetched(YoutubeModel youtubeModel);
    Observable<YoutubeModel> getYoutubeModelObservable(String part, String maxResults, String playlistId, String key);
}
