package es.jcescudero15.javitan.hackathonapp.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.Event;
import es.jcescudero15.javitan.hackathonapp.rest.ApiService;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.CalendarFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.EventListFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.MainFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.PreferencesFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements MainFragment.onEventsListClickListener,
MainFragment.onCalendarClickListener, MainFragment.onMyEventsClickListener, MainFragment.onPreferencesClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);

        loadOpenDataJSON();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, new MainFragment())
                .commit();



    }

    private void loadOpenDataJSON(){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Cargando datos...");
        progressDialog.show();
        // Asynchronous
        Call<Event> call = ApiService.getApiService().getEvents();
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                Event events = response.body();
                Log.i("aaaaaa", "niiiice");
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                progressDialog.dismiss();
//                Toast.makeText(getApplication(), "FALLO", Toast.LENGTH_SHORT).show();
//                Log.i("aaaaaa", "failure");
            }
        });
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
}
