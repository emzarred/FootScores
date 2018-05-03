package com.example.pc.viewpager.Views;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.pc.viewpager.Adapters.PlayAdapter;
import com.example.pc.viewpager.Adapters.TabAdapter;
import com.example.pc.viewpager.Models.Fixture;
import com.example.pc.viewpager.Models.LeagueTable;
import com.example.pc.viewpager.Models.Player;
import com.example.pc.viewpager.Models.Players;
import com.example.pc.viewpager.Models.Standing;
import com.example.pc.viewpager.R;
import com.example.pc.viewpager.Retrofits.ApiClient;
import com.example.pc.viewpager.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PlayerActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();

    List<Player> list;
    private ApiInterface cmp;
    private RecyclerView rv;
    private SwipeRefreshLayout spr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        rv = (RecyclerView)findViewById(R.id.list);


        spr = (SwipeRefreshLayout)findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        getPlayers();



    }

    private void getPlayers() {
        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<Players> call = cmp.getAllPlayers();

        call.enqueue(new Callback<Players>() {
            @Override
            public void onResponse(Call<Players> call, Response<Players> response) {

                List<Player> list = (List<Player>) response.body().getPlayers();
                rv.setAdapter(new PlayAdapter(list));
            }

            @Override
            public void onFailure(Call<Players> call, Throwable t) {
            }

        });
    }

    @Override
    public void onRefresh() {
        Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                spr.setRefreshing(false);
            }
        }, 2000);
        getPlayers();
    }
}
