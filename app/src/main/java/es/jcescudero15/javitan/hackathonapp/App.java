package es.jcescudero15.javitan.hackathonapp;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Jose Carlos on 27/10/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Init Realm
        Realm.init(this);
//
//        // Realm Client initialization
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().modules(Realm.getDefaultModule())
//                .deleteRealmIfMigrationNeeded().build();
//        Realm.setDefaultConfiguration(realmConfiguration);
        RealmConfiguration config = new RealmConfiguration.Builder().name("myrealm.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}
