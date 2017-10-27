package es.jcescudero15.javitan.hackathonapp.ui.fragment;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.db.Evento;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalendarFragment extends Fragment {

    @BindView(R.id.compact_calendar_view)
    CompactCalendarView mCompactCalendar;

    @BindView(R.id.mes)
    TextView text;

    private Realm mRealm;

    private SimpleDateFormat mDateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    public CalendarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        ButterKnife.bind(this, view);
        mRealm = Realm.getDefaultInstance();
        setCalendar();
        return view;
    }

    private void setCalendar() {
        mCompactCalendar.setUseThreeLetterAbbreviation(true);
        text.setText(mDateFormatMonth.format(new Date()));

        mRealm.beginTransaction();
        RealmResults<Evento> allEvents = mRealm.where(Evento.class).findAll();
        mRealm.commitTransaction();

        for (Evento evento : allEvents) {

            // Converse String date to Date
            String dtStart = evento.getIntervalStart();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = format.parse(dtStart);
                Long milisecond = date.getTime();

                // Create new Event with information about one exercise
                Event event = new Event(Color.RED, milisecond, evento.getName());
                mCompactCalendar.addEvent(event);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Calendar listener to show exercises
        mCompactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                // List events of calendar
                List<Event> events = mCompactCalendar.getEvents(dateClicked);

                // Show all events for a day
                for (int i = 0; i < events.size(); i++) {
                    Toast.makeText(getActivity(), "Evento " + (i + 1) + ": "
                            + events.get(i).getData().toString(), Toast.LENGTH_SHORT).show();
                }
                if (events.size() == 0) {
                    Toast.makeText(getActivity(), "Ningún evento planeado para hoy", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                // Change date when scroll
                text.setText(mDateFormatMonth.format(firstDayOfNewMonth));
            }
        });

    }

}
