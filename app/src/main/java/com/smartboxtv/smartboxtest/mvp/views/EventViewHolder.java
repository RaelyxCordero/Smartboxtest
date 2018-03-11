package com.smartboxtv.smartboxtest.mvp.views;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartboxtv.smartboxtest.R;
import com.smartboxtv.smartboxtest.bdd.DataModels.Item;
import com.smartboxtv.smartboxtest.utils.MessageEventType;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by XPECTRA on 9/3/2018.
 */

public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
    @BindView(R.id.cardView)
    CardView cardView;
    Item item;

    EventViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void setItem (Item item){
        this.item = item;
    }

    @Override
    public void onClick(View view) {
        EventBus.getDefault().post(new Object[]{MessageEventType.HEY_VIEW_LAUNCH_EVENT_DETAIL,
                item.getMatchDay().getPhase().getOriginal(),
                item.getMatchDay().getNameMatchDay().getOriginal(),
                item.getEventStatus().getName().getEs(),
                String.valueOf(item.getMatchTime() / 60 + " Minutos"),
                item.getLocation().getOriginal()});
    }
}
