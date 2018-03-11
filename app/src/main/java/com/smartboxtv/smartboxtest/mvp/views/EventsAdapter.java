package com.smartboxtv.smartboxtest.mvp.views;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartboxtv.smartboxtest.R;
import com.smartboxtv.smartboxtest.bdd.DataModels.Item;
import com.smartboxtv.smartboxtest.utils.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XPECTRA on 9/3/2018.
 */

public class EventsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> listItem;
    private Context mContext;
    private static final int ITEM = 0;
    private static final int LOADING = 1;

    private boolean isLoadingAdded = false;

    public EventsAdapter(List<Item> lista, Context context) {
        listItem = lista;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.card_event, parent, false);
                viewHolder = new EventViewHolder(viewItem);
                break;
            case LOADING:
                View viewLoading = inflater.inflate(R.layout.card_progress, parent, false);
                viewHolder = new LoadingVH(viewLoading);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder mHolder, int position) {
        if (getItemViewType(position) == ITEM) {
            Item item = listItem.get(position);
            final EventViewHolder holder = (EventViewHolder) mHolder;
            if (item != null){
                holder.setItem(getItem(position));

                if (item.getHomeTeam() != null && item.getAwayTeam() != null){
//                if (!item.getHomeTeam().getShortName().equals(""))
                    holder.ivFirstteam.setImageResource(Utils.getImageResource(item.getHomeTeam().getShortName()));

//                if (!item.getAwayTeam().getShortName().equals(""))
                    holder.ivSecondTeam.setImageResource(Utils.getImageResource(item.getAwayTeam().getShortName()));

//                if (!item.getHomeTeam().getName().equals(""))
                    holder.tvFirstteam.setText(item.getHomeTeam().getName());

//                if (!item.getAwayTeam().getName().equals(""))
                    holder.tvSecondTeam.setText(item.getAwayTeam().getName());

                    holder.tvFirstScore.setText(String.valueOf(item.getHomeScore()));
                    holder.tvSecondscore.setText(String.valueOf(item.getAwayScore()));
                    holder.tvDate.setText(Utils.changeDate(item.getStartDate()));
                }
            }

        }

    }

    @Override
    public int getItemCount() {
        return listItem == null ? 0 : listItem.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == listItem.size() - 1 && isLoadingAdded) ? LOADING : ITEM;

    }

    private void add(Item r) {
        listItem.add(r);
        notifyItemInserted(listItem.size() - 1);
    }

    public void addAll(List<Item> moreEvents) {
        removeLoadingFooter();
        for (Item result : moreEvents) {
            add(result);
        }
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new Item());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = listItem.size() - 1;
        Item result = getItem(position);

        if (result != null) {
            listItem.remove(position);
            notifyItemRemoved(position);
        }
    }

    public Item getItem(int position) {
        return listItem.get(position);
    }




    private class LoadingVH extends RecyclerView.ViewHolder {
        private LoadingVH(View itemView) {
            super(itemView);
        }
    }
}