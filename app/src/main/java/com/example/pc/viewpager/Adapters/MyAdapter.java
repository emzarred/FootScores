package com.example.pc.viewpager.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.viewpager.Models.Competition;
import com.example.pc.viewpager.R;
import com.example.pc.viewpager.Views.TeamView;

import java.util.List;

/**
 * Created by pc on 25/04/2018.
 */


public  class MyAdapter extends RecyclerView.Adapter {
    private List<Competition> list;

    public MyAdapter(List<Competition> list)
    {
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.comp_cell, parent, false);
        return new MyAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Competition competition = list.get(position);

        MyAdapter.ViewHolder.caption.setText(competition.getCaption() + "(" + String.valueOf(competition.getCurrentMatchday()) +"/" + String.valueOf(competition.getNumberOfMatchdays()) + ")");


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

        static TextView caption;




        public ViewHolder(View v) {
            super(v);

            caption = (TextView) v.findViewById(R.id.TvCap);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(itemView.getContext(),TeamView.class);

                    itemView.getContext().startActivity(intent);
                }
            });


        }

    }



}
