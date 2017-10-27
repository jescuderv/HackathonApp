package es.jcescudero15.javitan.hackathonapp.ui.activity;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.db.Evento;
import es.jcescudero15.javitan.hackathonapp.model.dto.Binding;
import es.jcescudero15.javitan.hackathonapp.model.dto.Event;
import es.jcescudero15.javitan.hackathonapp.rest.ApiService;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.CalendarFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.EventFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.EventListFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.MainFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.PreferencesFragment;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements MainFragment.onEventsListClickListener,
        MainFragment.onCalendarClickListener, MainFragment.onMyEventsClickListener, MainFragment.onPreferencesClickListener,
        EventListFragment.onClickEventDetailsListener{

    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ButterKnife.bind(this);

        Realm.init(this);
        mRealm = Realm.getDefaultInstance();

        loadOpenDataJSON();

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, new MainFragment())
                .commit();


    }


    private void loadOpenDataJSON() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Cargando datos...");
        progressDialog.show();
        // Asynchronous
        Call<Event> call = ApiService.getApiService().getEvents();
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                final Event events = response.body();
                List<Binding> eventsList = events.getResults().getBindings();

                mRealm.beginTransaction();
                Evento firstEvento = mRealm.where(Evento.class).findFirst();
                if (firstEvento != null){
                    mRealm.delete(Evento.class);
                }
                for (Binding eventBinding : eventsList){
                    Evento evento = mRealm.createObject(Evento.class);
                    if (eventBinding.getUri() != null){
                        evento.setUri(eventBinding.getUri().getValue());
                    }
                    if (eventBinding.getRdfs_comment() != null){
                        evento.setComment(eventBinding.getRdfs_comment().getValue());
                    }
                    if (eventBinding.getGeo_long() != null){
                        evento.setLongitude(eventBinding.getGeo_long().getValue());
                    }
                    if (eventBinding.getGeo_lat() != null){
                        evento.setLatitude(eventBinding.getGeo_lat().getValue());
                    }
                    if (eventBinding.getOm_seccionProcedencia() != null){
                        evento.setSection(eventBinding.getOm_seccionProcedencia().getValue());
                    }
                    if (eventBinding.getOm_horarioEvento() != null){
                        evento.setTime(eventBinding.getOm_horarioEvento().getValue());
                    }
                    if (eventBinding.getEvent_place() != null){
                        evento.setEventPlace(eventBinding.getEvent_place().getValue());
                    }
                    if (eventBinding.getOm_categoriaEvento() != null){
                        evento.setCategory(eventBinding.getOm_categoriaEvento().getValue());
                    }
                    if (eventBinding.getRdfs_label() != null){
                        evento.setName(eventBinding.getRdfs_label().getValue());
                    }
                    if (eventBinding.getEvent_time_intervalStarts() != null){
                        evento.setIntervalStart(eventBinding.getEvent_time_intervalStarts().getValue());
                    }
                    if (eventBinding.getEvent_time_intervalFinishes() != null){
                        evento.setIntervalFinish(eventBinding.getEvent_time_intervalFinishes().getValue());
                    }
                }
                mRealm.commitTransaction();

                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
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
    public void onClickEventDetails(Evento evento) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("evento", evento);
        Fragment fragment = new EventFragment();
        fragment.setArguments(bundle);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_main, fragment)
                .addToBackStack(null)
                .commit();
    }
}
