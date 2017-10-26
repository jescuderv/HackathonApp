package es.jcescudero15.javitan.hackathonapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.ApiAdapter;
import es.jcescudero15.javitan.hackathonapp.model.Event;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.CalendarFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.EventListFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.MainFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.PreferencesFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements MainFragment.onEventsListClickListener,
MainFragment.onCalendarClickListener, MainFragment.onMyEventsClickListener, MainFragment.onPreferencesClickListener, Callback<ArrayList<Event>> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, new MainFragment())
                .addToBackStack(null)
                .commit();

        Call<ArrayList<Event>> call = ApiAdapter.getApiService().getEvents();
        call.enqueue(this);
    }


    @Override
    public void onClickEventList() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, new EventListFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClickCalendar() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, new CalendarFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onClickMyEvents() {
        startActivity(new Intent(this, MyEventsActivity.class));
    }

    @Override
    public void onClickPreferences() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, new PreferencesFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
        if (response.isSuccessful()){
            ArrayList<Event> events = response.body();
            Log.d("onResponse events", "El tamaño del array es de => " + events.size());
            Toast.makeText(this, events.size(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
        Toast.makeText(this, "FALLO",Toast.LENGTH_SHORT).show();
    }
}
