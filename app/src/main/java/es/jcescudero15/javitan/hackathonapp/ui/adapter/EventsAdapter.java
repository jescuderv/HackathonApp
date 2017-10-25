package es.jcescudero15.javitan.hackathonapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import es.jcescudero15.javitan.hackathonapp.R;
import es.jcescudero15.javitan.hackathonapp.model.Event;

/**
 * Created by josecarlos on 24/10/17.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder>{

    /** Interface for on event click **/
    public interface OnEventClickListener{
        void OnClickEvent(Event event);
    }

    private OnEventClickListener mListener;
    private Context mContext;
    private ArrayList<Event> mEventList;


    /** Default constructor **/
    public EventsAdapter(OnEventClickListener mListener, Context mContext, ArrayList<Event> mEventList) {
        this.mListener = mListener;
        this.mContext = mContext;
        this.mEventList = mEventList;
    }



    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position) {
//        holder.bind(mEventList.get(position), mListener);
        holder.bind(null, mListener);
    }

    @Override
    public int getItemCount() {
        return 10;
//        return mEventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Event event, final OnEventClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnClickEvent(event);
                }
            });
        }
    }



}
