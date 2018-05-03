package com.example.pc.viewpager.Adapters;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pc.viewpager.Models.Fixture;
import com.example.pc.viewpager.Models.Team;
import com.example.pc.viewpager.R;
import com.example.pc.viewpager.Views.DetailActivity;
import com.example.pc.viewpager.Views.PlayerActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by pc on 26/04/2018.
 */

public class TeamAdapter extends RecyclerView.Adapter {

    private List<Team>list;



    public TeamAdapter(List<Team> list) {
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.comp_cell,parent,false);
        return new TeamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Team team = list.get(position);


        ViewHolder.caption.setText(team.getName());



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
                    Intent intent=new Intent(itemView.getContext(),PlayerActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

}




