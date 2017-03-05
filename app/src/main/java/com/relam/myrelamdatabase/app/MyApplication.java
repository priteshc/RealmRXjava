package com.relam.myrelamdatabase.app;

import android.app.Application;

import com.relam.myrelamdatabase.MyapplicationRealmModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by pritesh on 3/4/2017.
 */

public class MyApplication extends Application {

    public static final String YOUTUBE_URL = "https://www.googleapis.com/";
    public static final String apiKey = "AIzaSyCkDzdPliFsELIiiiBYQWS7HbazAvOaGFs";
    public static final String playlistId = "PLm_MSClsnwm-ewO0fw5Hgnulw9bviXmUE";
    public static final String PART = "snippet";
    public static final String MAXRESULT = "50";

    private  static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("MAGIC.realm").
                        modules(new MyapplicationRealmModule()).build();

        Realm.setDefaultConfiguration(configuration);


    }
}
