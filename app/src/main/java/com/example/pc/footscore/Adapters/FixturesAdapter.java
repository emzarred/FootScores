package com.example.pc.footscore.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.R;

import java.util.List;

/**
 * Created by pc on 01/05/2018.
 */

public class FixturesAdapter extends RecyclerView.Adapter {
    private List<Fixture> list;
   // private List<Result> listR;

    public FixturesAdapter(List<Fixture> list) {this.list=list;
    //this.listR=listR;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.fix_cell,parent,false);
        return new FixturesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Fixture fixture = list.get(position);
        //Result result = listR.get(position);

        ViewHolder.TvDate.setText(fixture.getDate()  );
        ViewHolder.TvHome.setText(fixture.getHomeTeamName());
       // ViewHolder.TvScore.setText(result.getGoalsHomeTeam() + "-" + result.getGoalsAwayTeam());
        ViewHolder.TvAway.setText(fixture.getAwayTeamName());
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

        static TextView TvDate,TvHome, TvAway,TvScore;




        public ViewHolder(View v) {
            super(v);

            TvDate= (TextView)v.findViewById(R.id.TvDate);
            TvHome=(TextView)v.findViewById(R.id.TvHome);
            TvScore=(TextView)v.findViewById(R.id.TvScore);
            TvAway=(TextView)v.findViewById(R.id.TvAway);


        }
    }

}
