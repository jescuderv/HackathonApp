package es.jcescudero15.javitan.hackathonapp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.CalendarFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.EventListFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.MainFragment;
import es.jcescudero15.javitan.hackathonapp.ui.fragment.PreferencesFragment;


public class MainActivity extends AppCompatActivity implements MainFragment.onEventsListClickListener,
MainFragment.onCalendarClickListener, MainFragment.onMyEventsClickListener, MainFragment.onPreferencesClickListener{


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
