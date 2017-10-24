package es.jcescudero15.javitan.hackathonapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONArray;

import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.JSONparser;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public class MainActivity extends AppCompatActivity {

String url = "http://dl.opendata.caceres.es/GetData/GetData?dataset=event:Event&format=json";
JSONArray events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void getJSON(){
        JSONparser jp = new JSONparser();
        String jsonString = jp.makeServiceCall(URL, JSONparser.GET);
    }
}
