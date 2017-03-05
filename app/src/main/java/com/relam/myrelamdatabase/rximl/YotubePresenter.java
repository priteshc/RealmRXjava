package com.relam.myrelamdatabase.rximl;

import com.relam.myrelamdatabase.pojo.YoutubeModel;

import rx.Observer;

/**
 * Created by pritesh on 3/4/2017.
 */

public class YotubePresenter extends BasePresenter implements Observer<YoutubeModel> {

    private YoutubeDataInterface youtubeDataInterface;

    public YotubePresenter(YoutubeDataInterface youtubeDataInterface) {
        this.youtubeDataInterface = youtubeDataInterface;
    }

    @Override
    public void onCompleted() {
        youtubeDataInterface.onYoutubeDataFetchedComplete();
    }

    @Override
    public void onError(Throwable e) {
        youtubeDataInterface.onYoutubeFetchError(e.getMessage());
    }

    @Override
    public void onNext(YoutubeModel youtubeModel) {
        youtubeDataInterface.onYotubeFetched(youtubeModel);
    }

    public void fetchYoutubeData(String part, String maxRsult, String playlistId, String apikey) {
        subscribe(youtubeDataInterface.getYoutubeModelObservable(part, maxRsult, playlistId, apikey),
                YotubePresenter.this);
    }
}
