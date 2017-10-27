package es.jcescudero15.javitan.hackathonapp.ui.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.db.Evento;
import es.jcescudero15.javitan.hackathonapp.ui.adapter.EventsAdapter;
import io.realm.Realm;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventListFragment extends Fragment {

    public interface onClickEventDetailsListener{
        void onClickEventDetails(Evento evento);
    }

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Realm mRealm;
    private onClickEventDetailsListener mListener;


    public EventListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (onClickEventDetailsListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_event_list);
        mRealm = Realm.getDefaultInstance();
        listarElementos();
        return view;
    }

    private void listarElementos() {
        ArrayList<Evento> mList = new ArrayList<>();

        mRealm.beginTransaction();
        RealmResults<Evento> allEvents = mRealm.where(Evento.class).findAll();
        for (Evento evento : allEvents){
            mList.add(evento);
        }
        mRealm.commitTransaction();


        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new EventsAdapter(new EventsAdapter.OnEventClickListener() {
            @Override
            public void OnClickEvent(Evento evento) {
                mListener.onClickEventDetails(evento);
            }
        }, mList);
        mRecyclerView.setAdapter(mAdapter);
    }


}
