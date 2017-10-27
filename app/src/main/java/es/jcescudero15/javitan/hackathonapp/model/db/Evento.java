package es.jcescudero15.javitan.hackathonapp.model.db;

import io.realm.RealmObject;

/**
 * Created by Javitan on 27/10/2017.
 */

public class Evento extends RealmObject {

    private String uri;
    private String comment;
    private String longitude;
    private String latitude;
    private String section;
    private String time;
    private String eventPlace;
    private String category;
    private String name;
    private String intervalStart;
    private String intervalFinish;

    public Evento() {

    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(String intervalStart) {
        this.intervalStart = intervalStart;
    }

    public String getIntervalFinish() {
        return intervalFinish;
    }

    public void setIntervalFinish(String intervalFinish) {
        this.intervalFinish = intervalFinish;
    }
}