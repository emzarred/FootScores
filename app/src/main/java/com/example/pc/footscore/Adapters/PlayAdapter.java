package com.example.pc.footscore.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pc.footscore.Models.Player;
import com.example.pc.footscore.R;

import java.util.List;

/**
 * Created by pc on 01/05/2018.
 */

public class PlayAdapter extends RecyclerView.Adapter {
    private List<Player>list;
    public PlayAdapter(List<Player> list) {this.list=list;


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.comp_cell,parent,false);
        return new PlayAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Player player = list.get(position);


        PlayAdapter.ViewHolder.caption.setText(player.getName());
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


        }
    }
}
