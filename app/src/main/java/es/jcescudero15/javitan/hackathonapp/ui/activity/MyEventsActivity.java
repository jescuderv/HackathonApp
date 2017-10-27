package es.jcescudero15.javitan.hackathonapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

import es.jcescudero15.javitan.hackathonapp.R;

public class MyEventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();

        tabs.addTab(tabs.newTabSpec("asistire"));
//
//        TabHost.TabSpec spec=tabs.newTabSpec("Asistiré");
//        tabs.addTab(spec);
//
//        spec=tabs.newTabSpec("mitab2");
//        tabs.addTab(spec);

        tabs.setCurrentTab(0);

    }
}
