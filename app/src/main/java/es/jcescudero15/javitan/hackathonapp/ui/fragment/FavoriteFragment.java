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
import es.jcescudero15.javitan.hackathonapp.model.db.User;
import es.jcescudero15.javitan.hackathonapp.ui.adapter.EventsAdapter;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Realm mRealm;
    private EventListFragment.onClickEventDetailsListener mListener;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (EventListFragment.onClickEventDetailsListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_event_favorites);
        mRealm = Realm.getDefaultInstance();
        listarElementos();
        return view;
    }


    private void listarElementos(){
        ArrayList<Evento> listaAsistir = new ArrayList<>();

        mRealm.beginTransaction();
        RealmResults<User> user = mRealm.where(User.class).findAll();
        for (User user1 : user){
            if (user1.getEventListAssist() != null) {
                for (Evento evento : user1.getEventListAssist())
                listaAsistir.add(evento);
            }
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
        }, listaAsistir, getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }


}
