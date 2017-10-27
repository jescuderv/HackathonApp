package es.jcescudero15.javitan.hackathonapp.model.db;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Javitan on 27/10/2017.
 */

public class User extends RealmObject{

    private RealmList<Evento> eventListFavorites;
    private RealmList<Evento> eventListAssist;
    

}
