package es.jcescudero15.javitan.hackathonapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.db.Evento;
import es.jcescudero15.javitan.hackathonapp.model.db.User;
import io.realm.Realm;
import io.realm.RealmResults;

public class MyEventsActivity extends AppCompatActivity {

    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
        /*mRealm = Realm.getDefaultInstance();
        listarMisEventos();*/
    }

    private void listarMisEventos(){
        /*ArrayList<Evento> mFavoriteList = new ArrayList<>();
        mRealm.beginTransaction();
        RealmResults<Evento> userEvents = mRealm.where(User.class).findAll();
        for (Evento evento : allEvents){
            mFavoriteList.add(evento);
        }
        mRealm.commitTransaction();*/
    }
}
