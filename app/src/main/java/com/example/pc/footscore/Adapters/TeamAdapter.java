package com.example.pc.footscore.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.pc.footscore.Models.Team;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Views.PlayerActivity;
import com.example.pc.footscore.Views.TeamDetail;

import java.util.List;

/**
 * Created by pc on 26/04/2018.
 */

public class TeamAdapter extends RecyclerView.Adapter {

    private List<Team>list;
public static Context context;
private ImageView flag;

    public TeamAdapter(List<Team> list, Context context) {
        this.list=list;
        this.context=context;
    }
   /* public TeamAdapter(List<Team> list) {
        this.list=list;}*/


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.team_cell,parent,false);
        return new TeamAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Team team = list.get(position);

      //Glide.with(context).load(team.getCrestUrl().toString()).override(30,50).into(ViewHolder.flag);
        ViewHolder.caption.setText(team.getName());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        static TextView caption;
static ImageView flag;


        public ViewHolder(View v) {
            super(v);
flag=(ImageView)v.findViewById(R.id.flag);
            caption = (TextView) v.findViewById(R.id.TvCap);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(itemView.getContext(),TeamDetail.class);
                    itemView.getContext().startActivity(intent);
                }
            });


        }
    }

}




