package com.relam.myrelamdatabase.callback;

import com.relam.myrelamdatabase.pojo.Book;

import java.util.ArrayList;

/**
 * Created by pritesh on 3/4/2017.
 */

public interface IBookRepository {


    void onAdd(ArrayList<Book> books, onAddedCallback callback);

    void fetchByBookNAme(String bookname,onFetchCallback onFetchCallback);


/* //   void onDelete();
//    void onUpdate();
    void onAddById();
    void onDeleteById();

    void onUpdateByName();
    */




}
