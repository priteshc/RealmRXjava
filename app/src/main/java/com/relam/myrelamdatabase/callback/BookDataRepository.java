package com.relam.myrelamdatabase.callback;

import android.util.Log;

import com.relam.myrelamdatabase.pojo.Book;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by pritesh on 3/4/2017.
 */

public class BookDataRepository implements IBookRepository {
    @Override
    public void onAdd(final ArrayList<Book> books, final onAddedCallback callback) {
        Realm realm = Realm.getDefaultInstance();
        try {
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    for (Book book: books) {
                        Book book1 = realm.createObject(Book.class);
                        book1.setBookname(book.getBookname());
                        book1.setBookauthor(book.getBookauthor());
                    }
                    callback.onSuccess();
                }
            });
        }catch (Exception e) {
            Log.d("Exception", e.getMessage());

        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public void fetchByBookNAme(final String bookname, final onFetchCallback onFetchCallback) {

        Realm realm = Realm.getDefaultInstance();



        try {

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    RealmResults<Book>results = realm.where(Book.class).equalTo(Book.BOOK_NAME,bookname).findAll();

                    onFetchCallback.onSuccess(results);



                }

            });


        }
        catch (Exception e){




        }
        finally {



        }




    }
}
