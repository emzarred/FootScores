package com.example.pc.viewpager.Controllers.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.viewpager.Adapters.MyAdapter;
import com.example.pc.viewpager.Adapters.TeamAdapter;
import com.example.pc.viewpager.Models.Competition;
import com.example.pc.viewpager.Models.Team;
import com.example.pc.viewpager.R;
import com.example.pc.viewpager.Retrofits.ApiClient;
import com.example.pc.viewpager.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by pc on 26/04/2018.
 */

public class test extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();
    SwipeRefreshLayout spr;
    List<Team> list;
    private ApiInterface cmp;
    private RecyclerView rv,rv8;
    private TextView e,z;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page);
        setTitle("Competition");
        rv = (RecyclerView) findViewById(R.id.list);
        //  rv8=(RecyclerView)findViewById(R.id.list8);

        spr = (SwipeRefreshLayout) findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        // rv8.setLayoutManager(new LinearLayoutManager(this));



        getMatch();
        // getMatch_2018();


    }

   private void getMatch() {
       final ApiInterface cmp = retrofit.create(ApiInterface.class);
       Call<List<Team>> call = cmp.getAllTeams();
       call.enqueue(new Callback<List<Team>>() {
           @Override
           public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {

               List<Team> list = (List<Team>) response.body();
               rv.setAdapter(new TeamAdapter(list));


           }

           @Override
           public void onFailure(Call<List<Team>> call, Throwable t) {


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
        getMatch();
        //getMatch_2018();


    }
}
