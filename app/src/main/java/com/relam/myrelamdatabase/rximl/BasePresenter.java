package com.relam.myrelamdatabase.rximl;

/**
 * Created by pritesh on 3/4/2017.
 */

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
/**
 * Created by rkodekar on 1/12/17.
 */

public class BasePresenter implements PresenterInterface {

    private CompositeSubscription compositeSubscription;

    @Override
    public void onCreate() {

    }

    @Override
    public void onResume() {

        configureSubscription();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        unSubscribeAll();
    }

    private CompositeSubscription configureSubscription() {
        if (compositeSubscription == null  ||  compositeSubscription.isUnsubscribed())  {
            compositeSubscription = new CompositeSubscription();
        }

        return compositeSubscription;
    }

    protected void unSubscribeAll() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
//            compositeSubscription = null;
        }
    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> observer) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe(observer);
        configureSubscription().add(subscription);
    }
}
