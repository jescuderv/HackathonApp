package es.jcescudero15.javitan.hackathonapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.db.Evento;

/**
 * Created by josecarlos on 24/10/17.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder>{

    /** Interface for on event click **/
    public interface OnEventClickListener{
        void OnClickEvent(Evento evento);
    }

    private OnEventClickListener mListener;
    private ArrayList<Evento> mEventList;


    /** Default constructor **/
    public EventsAdapter(OnEventClickListener mListener, ArrayList<Evento> mEventList) {
        this.mListener = mListener;
        this.mEventList = mEventList;
    }



    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position) {
        holder.bind(mEventList.get(position), mListener);
//        holder.bind(null, mListener);
    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_layout_background)
        LinearLayout mLinearLayout;

        @BindView(R.id.item_image_category_event)
        ImageView mImageCategory;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Evento evento, final OnEventClickListener listener){
            String categoryEvent = evento.getCategory();
            if (categoryEvent != null) {
                if (categoryEvent.contains("Concierto")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.concierto);
                } else if (categoryEvent.contains("Conferencia")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.conferencia);
                } else if (categoryEvent.contains("Deportes")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.deporte);
                } else if (categoryEvent.contains("Exposicion")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.exposicion);
                } else if (categoryEvent.contains("Entrega de premios")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.entregapremios);
                } else if (categoryEvent.contains("Feria")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.feria);
                } else if (categoryEvent.contains("Congreso")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.congreso);
                } else if (categoryEvent.contains("Encuentro")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.encuentro);
                } else if (categoryEvent.contains("Festival")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.festival);
                } else if (categoryEvent.contains("Fiesta popular")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.fiestapopular);
                } else if (categoryEvent.contains("Música")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.musica);
                } else if (categoryEvent.contains("Poesía")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.poesia);
                } else if (categoryEvent.contains("Otros")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.otros);
                } else if (categoryEvent.contains("Presentación de libro")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.presentacionlibro);
                } else if (categoryEvent.contains("Teatro/Cine")) {
                    //color
                    mImageCategory.setImageResource(R.drawable.teatrocine);
                }
            } else{
                mImageCategory.setImageResource(R.drawable.otros);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClickEvent(evento);
                }
            });

        }
    }



}
