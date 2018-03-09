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

    EventViewHolder(View itemView) {
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
