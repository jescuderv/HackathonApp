package es.jcescudero15.javitan.hackathonapp.ui.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.Event;
import es.jcescudero15.javitan.hackathonapp.ui.adapter.EventsAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public EventListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_event_list);
        listarElementos();
        return view;
    }

    private void listarElementos() {
        ArrayList<Event> mList = new ArrayList<>();

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EventsAdapter(new EventsAdapter.OnEventClickListener() {
            @Override
            public void OnClickEvent(Event event) {

            }
        }, getActivity(), mList);
        mRecyclerView.setAdapter(mAdapter);
    }


}
