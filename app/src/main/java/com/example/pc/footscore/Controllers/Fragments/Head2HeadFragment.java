package com.example.pc.footscore.Controllers.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.footscore.Models.Fixture;
import com.example.pc.footscore.Models.Result;
import com.example.pc.footscore.R;
import com.example.pc.footscore.Retrofits.ApiClient;
import com.example.pc.footscore.Retrofits.ApiInterface;

import java.util.List;

import retrofit2.Retrofit;


/**

 */
public class Head2HeadFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    ApiClient configRetro = new ApiClient();
    Retrofit retrofit = configRetro.getClient();



    private ApiInterface cmp;
    private RecyclerView rv;
    private SwipeRefreshLayout spr;
    private static final String KEY_POSITION="position";
    private static final String KEY_COLOR="color";


    public Head2HeadFragment() { }


    // 2 - Method that will create a new instance of CompetitionFragment, and add data to its bundle.
    public static Head2HeadFragment newInstance(int position, int color) {

        // 2.1 Create new fragment
        Head2HeadFragment frag = new Head2HeadFragment();

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
        rv = (RecyclerView) result.findViewById(R.id.list);


        spr = (SwipeRefreshLayout) result.findViewById(R.id.swipe);
        spr.setOnRefreshListener((SwipeRefreshLayout.OnRefreshListener) this);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        // 5 - Get data from Bundle (created in method newInstance)
        int position = getArguments().getInt(KEY_POSITION, -1);
        int color = getArguments().getInt(KEY_COLOR, -1);

        // 6 - Update widgets with it
        rootView.setBackgroundColor(color);
        // textView.setText("Page numéro "+position);

        //Log.e(getClass().getSimpleName(), "onCreateView called for fragment number "+position);

        return result;
    }

    @Override
    public void onRefresh() {
        Toast.makeText(getContext(), "Refresh", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                spr.setRefreshing(false);
            }
        }, 2000);
    }
}
