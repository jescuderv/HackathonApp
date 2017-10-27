package es.jcescudero15.javitan.hackathonapp.ui.fragment;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.db.Evento;
import io.realm.Realm;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    @BindView(R.id.item_title_event_single)
    TextView mTitleEvent;

    @BindView(R.id.item_category_single)
    TextView mCategoryEvent;

    @BindView(R.id.item_place_single)
    TextView mPlaceEvent;

    @BindView(R.id.item_time_single)
    TextView mTimeEvent;

    @BindView(R.id.item_comienzo_single)
    TextView mStartEvent;

    @BindView(R.id.item_final_single)
    TextView mEndEvent;

    @BindView(R.id.item_comments_single)
    TextView mCommentsEvent;

    @BindView(R.id.item_section_single)
    TextView mSectionEvent;

    @BindView(R.id.item_image_category_event_single)
    ImageView mImageCategory;

    @BindView(R.id.item_layout_background_single)
    LinearLayout mBackground;


    private Evento mEvento;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_event, container, false);
        ButterKnife.bind(this, view);
        // Get prodcuts item from bundle arguments
        Bundle args = getArguments();
        mEvento = (Evento) args.getSerializable("evento");
        setValues();
        return view;
    }

    private void setValues(){
        //Log.i("evento", mEvento.getCategory());
        String categoryEvent = mEvento.getCategory();
        if (categoryEvent != null) {
            if (categoryEvent.contains("Concierto")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color1));
                mImageCategory.setImageResource(R.drawable.concierto);
            } else if (categoryEvent.contains("Conferencia")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color2));
                mImageCategory.setImageResource(R.drawable.conferencia);
            } else if (categoryEvent.contains("Deportes")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color3));
                mImageCategory.setImageResource(R.drawable.deporte);
            } else if (categoryEvent.contains("Exposicion")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color4));
                mImageCategory.setImageResource(R.drawable.exposicion);
            } else if (categoryEvent.contains("Entrega de premios")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color5));
                mImageCategory.setImageResource(R.drawable.entregapremios);
            } else if (categoryEvent.contains("Feria")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color6));
                mImageCategory.setImageResource(R.drawable.feria);
            } else if (categoryEvent.contains("Congreso")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color7));
                mImageCategory.setImageResource(R.drawable.congreso);
            } else if (categoryEvent.contains("Encuentro")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color8));
                mImageCategory.setImageResource(R.drawable.encuentro);
            } else if (categoryEvent.contains("Festival")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color9));
                mImageCategory.setImageResource(R.drawable.festival);
            } else if (categoryEvent.contains("Fiesta popular")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color10));
                mImageCategory.setImageResource(R.drawable.fiestapopular);
            } else if (categoryEvent.contains("Música")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color11));
                mImageCategory.setImageResource(R.drawable.musica);
            } else if (categoryEvent.contains("Poesía")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color12));
                mImageCategory.setImageResource(R.drawable.poesia);
            } else if (categoryEvent.contains("Otros")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color13));
                mImageCategory.setImageResource(R.drawable.otros);
            } else if (categoryEvent.contains("Presentación de libro")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color14));
                mImageCategory.setImageResource(R.drawable.presentacionlibro);
            } else if (categoryEvent.contains("Teatro/Cine")) {
                mBackground.setBackgroundColor(getResources().getColor(R.color.color15));
                mImageCategory.setImageResource(R.drawable.teatrocine);
            }
        } else{
            mImageCategory.setImageResource(R.drawable.otros);
        }
        mTitleEvent.setText(mEvento.getName());
        mCategoryEvent.setText("CATEGORÍA: " + mEvento.getCategory());
        mCommentsEvent.setText("COMENTARIO: " + mEvento.getComment());
        mPlaceEvent.setText("LUGAR: " + mEvento.getEventPlace());
        mTimeEvent.setText("HORARIO: " + mEvento.getTime());
        mStartEvent.setText("COMIENZO: " + mEvento.getIntervalStart());
        mEndEvent.setText("FINALIZA: " + mEvento.getIntervalFinish());
        mSectionEvent.setText("SECCIÓN: " + mEvento.getSection());
    }


}
