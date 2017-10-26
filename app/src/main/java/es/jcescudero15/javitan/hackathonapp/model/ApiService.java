package es.jcescudero15.javitan.hackathonapp.model;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Javitan on 26/10/2017.
 */

public interface ApiService {

    @GET("GetData?dataset=event:Event&format=json")
    Call<ArrayList<Event>> getEvents();

}
