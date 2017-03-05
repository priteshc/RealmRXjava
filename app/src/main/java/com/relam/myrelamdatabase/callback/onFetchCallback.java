package com.relam.myrelamdatabase.callback;

import com.relam.myrelamdatabase.pojo.Book;

import io.realm.RealmResults;

/**
 * Created by pritesh on 3/4/2017.
 */

public interface onFetchCallback {

    void onSuccess(RealmResults<Book> books);

}
