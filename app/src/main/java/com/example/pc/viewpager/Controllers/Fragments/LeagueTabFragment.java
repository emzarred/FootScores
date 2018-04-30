package com.example.pc.viewpager.Controllers.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pc.viewpager.Adapters.TabAdapter;
import com.example.pc.viewpager.Adapters.TeamAdapter;
import com.example.pc.viewpager.Models.LeagueTable;
import com.example.pc.viewpager.Models.Standing;
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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link} interface
 * to handle interaction events.
 * Use the {@link LeagueTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeagueTabFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";
    private RecyclerView rv;
    private SwipeRefreshLayout spr;
    List<Standing> list;
    private ApiInterface cmp;
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();

    public LeagueTabFragment() { }


    // 2 - Method that will create a new instance of CompetitionFragment, and add data to its bundle.
    public static LeagueTabFragment newInstance(int position, int color) {

        // 2.1 Create new fragment
        LeagueTabFragment frag = new LeagueTabFragment();

        // 2.2 Create bundle and add it some data
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putInt(KEY_COLOR, color);
        frag.setArguments(args);

        return(frag);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 3 - Get layout of CompetitionFragment
        View result = inflater.inflate(R.layout.fragment_page, container, false);

        // 4 - Get widgets from layout and serialise it
        LinearLayout rootView= (LinearLayout) result.findViewById(R.id.fragment_page_rootview);
        TextView textView= (TextView) result.findViewById(R.id.fragment_page_title);
        spr = (SwipeRefreshLayout) result.findViewById(R.id.swipe);
        rv = (RecyclerView) result.findViewById(R.id.list);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        getTab();

        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it
        rootView.setBackgroundColor(color);
        // textView.setText("Page numéro "+position);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }

    private void getTab() {
        final ApiInterface cmp = retrofit.create(ApiInterface.class);
        Call<LeagueTable> call = cmp.getLeagueTable();
        Log.d("TeamView", "onResponse: "+call);
        call.enqueue(new Callback<LeagueTable>() {
            @Override
            public void onResponse(Call<LeagueTable> call, Response<LeagueTable> response) {
               // Log.d("TeamView", "onResponse: "+response.body().getTeams());
                List<Standing> list = (List<Standing>) response.body().getStanding();
                rv.setAdapter(new TabAdapter(list));
            }

            @Override
            public void onFailure(Call<LeagueTable> call, Throwable t) {
            }

        });

    }

    @Override
    public void onRefresh() {

    }
}
