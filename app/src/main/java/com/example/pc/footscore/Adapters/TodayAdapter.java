package com.example.pc.footscore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.pc.footscore.Controllers.Fragments.FavoritFragment;
import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.Models.Today;
import com.example.pc.footscore.R;

import java.util.List;

import static android.app.PendingIntent.getActivity;

/**
 * Created by pc on 07/05/2018.
 */

public class TodayAdapter extends RecyclerView.Adapter {
    private List<Fixture> list;
    // private List<Result> listR;

    public TodayAdapter(List<Fixture> list) {
        this.list = list;
        //this.listR=listR;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.day_cell, parent, false);
        return new TodayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture fixture = list.get(position);
        //Result result = listR.get(position);

        TodayAdapter.ViewHolder.TvDate.setText(fixture.getDate());
        TodayAdapter.ViewHolder.TvHome.setText(fixture.getHomeTeamName());
        //iewHolder.TvScore.setText((CharSequence) fixture.getResult());
        TodayAdapter.ViewHolder.TvAway.setText(fixture.getAwayTeamName());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        static TextView TvDate, TvHome, TvAway, TvScore;
        static CheckBox check;

        public ViewHolder(View v) {
            super(v);

            TvDate = (TextView) v.findViewById(R.id.TvDate);
            TvHome = (TextView) v.findViewById(R.id.TvHome);
            TvScore = (TextView) v.findViewById(R.id.TvScore);
            TvAway = (TextView) v.findViewById(R.id.TvAway);
            check = (CheckBox) v.findViewById(R.id.checkBox);
        }
    }
}
