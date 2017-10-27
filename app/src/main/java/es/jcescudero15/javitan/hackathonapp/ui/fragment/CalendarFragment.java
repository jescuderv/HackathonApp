package es.jcescudero15.javitan.hackathonapp.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {

    @BindView(R.id.compact_calendar_view)
    public CalendarView mCalendarView;

    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
