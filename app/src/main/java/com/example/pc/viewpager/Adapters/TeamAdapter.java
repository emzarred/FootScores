package com.example.pc.viewpager.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.viewpager.Models.Team;
import com.example.pc.viewpager.Models.Teams;
import com.example.pc.viewpager.R;

import java.util.List;

/**
 * Created by pc on 26/04/2018.
 */

public class TeamAdapter extends RecyclerView.Adapter {

private Teams teams;
private List<Team>list;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.comp_cell,parent,false);
        return new TeamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        teams.getTeams()
ViewHolder.caption.setText("hfr");
    }

    @Override
    public int getItemCount() {
        return teams.getCount();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        static TextView caption;




        public ViewHolder(View v) {
            super(v);

            caption = (TextView) v.findViewById(R.id.TvCap);


        }
    }

}




