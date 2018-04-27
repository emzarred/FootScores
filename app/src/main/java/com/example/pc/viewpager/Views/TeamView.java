package com.example.pc.viewpager.Views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pc.viewpager.Adapters.TeamAdapter;
import com.example.pc.viewpager.R;

/**
 * Created by pc on 27/04/2018.
 */

public class TeamView extends Activity {
private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_layout);
        rv=(RecyclerView)findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new TeamAdapter());


    }
}