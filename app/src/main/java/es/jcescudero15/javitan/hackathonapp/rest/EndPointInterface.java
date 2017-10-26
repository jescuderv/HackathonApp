package es.jcescudero15.javitan.hackathonapp.rest;

import es.jcescudero15.javitan.hackathonapp.model.Event;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Javitan on 26/10/2017.
 */

public interface EndPointInterface {

    @GET("GetData?dataset=event:Event&format=json")
    Call<Event> getEvents();

}
