package es.jcescudero15.javitan.hackathonapp.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.db.Evento;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    private Evento mEvento;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_event, container, false);

        // Get prodcuts item from bundle arguments
        Bundle args = getArguments();
        mEvento = (Evento) args.getSerializable("evento");

        return view;
    }

}
