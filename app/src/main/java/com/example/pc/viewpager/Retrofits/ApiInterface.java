package com.example.pc.viewpager.Retrofits;


import com.example.pc.viewpager.Models.Competition;
import com.example.pc.viewpager.Models.LeagueTable;
import com.example.pc.viewpager.Models.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pc on 25/04/2018.
 */

public interface ApiInterface {
    @GET( "competitions")
    Call<List<Competition>> getAllCompetitions();
    @GET("competitions/444/teams")
    Call<Teams> getAllTeams();
    @GET("competitions/398/leagueTable")
    Call<LeagueTable>getLeagueTable();


}
