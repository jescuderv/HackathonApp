package es.jcescudero15.javitan.hackathonapp.model.db;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Javitan on 27/10/2017.
 */

public class User extends RealmObject{

    private RealmList<Evento> eventListFavorites = new RealmList<>();
    private RealmList<Evento> eventListAssist = new RealmList<>();

    public User() {
    }

    public User(RealmList<Evento> eventListFavorites, RealmList<Evento> eventListAssist) {
        this.eventListFavorites = eventListFavorites;
        this.eventListAssist = eventListAssist;
    }

    public RealmList<Evento> getEventListFavorites() {
        return eventListFavorites;
    }

    public void setEventListFavorites(RealmList<Evento> eventListFavorites) {
        this.eventListFavorites = eventListFavorites;
    }

    public RealmList<Evento> getEventListAssist() {
        return eventListAssist;
    }

    public void setEventListAssist(RealmList<Evento> eventListAssist) {
        this.eventListAssist = eventListAssist;
    }
}
