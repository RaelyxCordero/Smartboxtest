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
                viewHolder = new EventVH(viewItem);
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
            final EventVH holder = (EventVH) mHolder;
            holder.cardView.setBackgroundColor(mContext.getResources().getColor(R.color.colorBackgroundCard));
//            if (Utils.mod(position) == 0) {
//                holder.cardView.setBackgroundColor(mContext.getResources().getColor(R.color.card_pair));
//            } else
//                holder.cardView.setBackgroundColor(mContext.getResources().getColor(R.color.card_odd));


            holder.ivFirstteam.setImageResource(Utils.getImageResource(listItem.get(position).getHomeTeam().getShortName()));
            holder.ivSecondTeam.setImageResource(Utils.getImageResource(listItem.get(position).getAwayTeam().getShortName()));
            holder.tvDate.setText(Utils.changeDate(listItem.get(position).getStartDate()));
            holder.tvFirstteam.setText(listItem.get(position).getHomeTeam().getName());
            holder.tvSecondTeam.setText(listItem.get(position).getAwayTeam().getName());
            holder.tvFirstScore.setText(String.valueOf(listItem.get(position).getHomeScore()));
            holder.tvSecondscore.setText(String.valueOf(listItem.get(position).getAwayScore()));
            holder.tvPhase.setText(listItem.get(position).getMatchDay().getPhase().getOriginal());
            holder.tvNameGroup.setText(listItem.get(position).getMatchDay().getNameMatchDay().getOriginal());
            holder.tvStatus.setText(listItem.get(position).getEventStatus().getName().getEs());
            holder.tvDuration.setText(listItem.get(position).getMatchTime() / 60 + " Minutos");
            holder.tvEstadium.setText(listItem.get(position).getLocation().getOriginal());
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

    public void addAll(List<Item> moveResults) {
        removeLoadingFooter();
        for (Item result : moveResults) {
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

    static class EventVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tvDate)
        TextView tvDate;
        @BindView(R.id.tvFirstteam)
        TextView tvFirstteam;
        @BindView(R.id.ivFirstteam)
        ImageView ivFirstteam;
        @BindView(R.id.tvFirstScore)
        TextView tvFirstScore;
        @BindView(R.id.tvSecondscore)
        TextView tvSecondscore;
        @BindView(R.id.ivSecondTeam)
        ImageView ivSecondTeam;
        @BindView(R.id.tvSecondTeam)
        TextView tvSecondTeam;
        @BindView(R.id.tvPhase)
        TextView tvPhase;
        @BindView(R.id.tvNameGroup)
        TextView tvNameGroup;
        @BindView(R.id.tvStatus)
        TextView tvStatus;
        @BindView(R.id.tvDuration)
        TextView tvDuration;
        @BindView(R.id.tvEstadium)
        TextView tvEstadium;
        @BindView(R.id.containerDetail)
        LinearLayout containerDetail;
        @BindView(R.id.cardView)
        CardView cardView;

        EventVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (containerDetail.getVisibility() == View.GONE) {
                containerDetail.setVisibility(View.VISIBLE);
                TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
            } else {
                containerDetail.setVisibility(View.GONE);
            }
        }
    }


    private class LoadingVH extends RecyclerView.ViewHolder {
        private LoadingVH(View itemView) {
            super(itemView);
        }
    }
}