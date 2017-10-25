package es.jcescudero15.javitan.hackathonapp.ui.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import es.jcescudero15.javitan.hackathonapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    /**
     * Interfaces for callback events
     */
    public interface onEventsListClickListener {
        void onClickEventList();
    }

    public interface onCalendarClickListener {
        void onClickCalendar();
    }

    public interface onMyEventsClickListener {
        void onClickMyEvents();
    }

    public interface onPreferencesClickListener {
        void onClickPreferences();
    }

    /** Listeners **/
    private onEventsListClickListener mEventsListListener;
    private onCalendarClickListener mCalendarListener;
    private onMyEventsClickListener mMyEventsListener;
    private onPreferencesClickListener mPreferencesListener;


    /** Empty constructor **/
    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mEventsListListener = (onEventsListClickListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.main_events_list)
    public void navigateToEventsList() {
        mEventsListListener.onClickEventList();
    }

    @OnClick(R.id.main_calendar)
    public void navigateToCalendar() {
        mCalendarListener.onClickCalendar();
    }

    @OnClick(R.id.main_my_events)
    public void navigateToMyEvents() {
        mMyEventsListener.onClickMyEvents();
    }

    @OnClick(R.id.main_preferences)
    public void navigateToPreferences() {
        mPreferencesListener.onClickPreferences();
    }

}
