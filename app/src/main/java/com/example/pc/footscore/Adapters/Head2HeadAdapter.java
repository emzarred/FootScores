package com.example.pc.footscore.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.footscore.Models.Team;
import com.example.pc.footscore.R;

import java.util.List;

/**
 * Created by pc on 10/05/2018.
 */

public class Head2HeadAdapter extends RecyclerView.Adapter {
    private List<Team>list;

    public Head2HeadAdapter(List<Team> list) {
        this.list=list;}
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.team_cell,parent,false);
        return new Head2HeadAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Team team=list.get(position);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }
}
