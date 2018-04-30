package com.example.pc.viewpager.Views;

import android.app.Activity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.pc.viewpager.Adapters.TeamAdapter;

import com.example.pc.viewpager.Models.Competition;
import com.example.pc.viewpager.Models.Team;
import com.example.pc.viewpager.Models.Teams;
import com.example.pc.viewpager.R;
import com.example.pc.viewpager.Retrofits.ApiClient;
import com.example.pc.viewpager.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * Created by pc on 27/04/2018.
 */

public class TeamView extends Activity {
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();
    private RecyclerView rv;
    private  List<Team>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_layout);
        rv=(RecyclerView)findViewById(R.id.list);
        rv.setLayoutManager(new LinearLayoutManager(this));
        getTeams();



    }

    private void getTeams() {



        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<Teams> call = cmp.getAllTeams();
        Log.d("TeamView", "onResponse: "+call);
        call.enqueue(new Callback<Teams>() {
            @Override
            public void onResponse(Call<Teams> call, Response<Teams> response) {
                Log.d("TeamView", "onResponse: "+response.body().getTeams());
                List<Team> list =response.body().getTeams();
                rv.setAdapter(new TeamAdapter(list));
            }

            @Override
            public void onFailure(Call<Teams> call, Throwable t) {
            }

        });

    }
}
