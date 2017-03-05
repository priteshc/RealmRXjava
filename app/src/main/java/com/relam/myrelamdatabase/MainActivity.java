package com.relam.myrelamdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.relam.myrelamdatabase.app.MyApplication;
import com.relam.myrelamdatabase.app.YoutubeClient;
import com.relam.myrelamdatabase.callback.BookDataRepository;
import com.relam.myrelamdatabase.callback.onAddedCallback;
import com.relam.myrelamdatabase.callback.onFetchCallback;
import com.relam.myrelamdatabase.pojo.Book;
import com.relam.myrelamdatabase.pojo.YoutubeModel;
import com.relam.myrelamdatabase.rximl.YotubePresenter;
import com.relam.myrelamdatabase.rximl.YoutubeDataInterface;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements YoutubeDataInterface {

    private YoutubeClient youtubeClient;
    private YotubePresenter yotubePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookDataRepository bookDataRepository = new BookDataRepository();
        youtubeClient = new YoutubeClient();
        yotubePresenter = new YotubePresenter(this);
        yotubePresenter.fetchYoutubeData(MyApplication.PART, MyApplication.MAXRESULT, MyApplication.playlistId, MyApplication.apiKey);
        Realm realm = Realm.getDefaultInstance();
        Book book = new Book();
        book.setBookauthor("Yash");
        book.setBookname("Let us c");
        ArrayList<Book> books = new ArrayList<>();
        books.add(book);
        bookDataRepository.onAdd(books, new onAddedCallback() {
            @Override
            public void onSuccess() {
            }
        });


        bookDataRepository.fetchByBookNAme("Let us c", new onFetchCallback() {
            @Override
            public void onSuccess(RealmResults<Book> books) {


            }
        });

        try {

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {


                    Book book = realm.createObject(Book.class);

                    book.setBookauthor("Rehan");
                    book.setBookname("Android");

                }
            });
        }
        catch (Exception e)
        {

            e.getMessage();

        }
        finally {

            if(realm!= null){

                realm.close();

            }

        }


    }

    @Override
    public void onYoutubeDataFetchedComplete() {

    }

    @Override
    public void onYoutubeFetchError(String error) {

    }

    @Override
    public void onYotubeFetched(YoutubeModel youtubeModel) {

        if (youtubeModel != null) {
            youtubeModel.getItems().size();
        }

    }

    @Override
    public Observable<YoutubeModel> getYoutubeModelObservable(String part, String maxResults, String playlistId, String key) {
        return youtubeClient.youtubeApi().getYoutubeData(part, maxResults, playlistId, key);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        yotubePresenter.onDestroy();
    }
}
