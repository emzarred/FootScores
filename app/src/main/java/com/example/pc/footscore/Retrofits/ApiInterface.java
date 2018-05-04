package com.example.pc.footscore.Retrofits;


import com.example.pc.footscore.Models.Competition;
import com.example.pc.footscore.Models.Fixtures;
import com.example.pc.footscore.Models.LeagueTable;
import com.example.pc.footscore.Models.Players;
import com.example.pc.footscore.Models.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by pc on 25/04/2018.
 */

public interface ApiInterface {
    @GET( "competitions")
    Call<List<Competition>> getAllCompetitions(@Query("year") String year);

            @GET("competitions/444/teams")
    Call<Teams> getAllTeams();
    @GET("competitions/398/leagueTable")
    Call<LeagueTable>getLeagueTable();
    @GET("competitions/398/fixtures?matchday=8")
    Call<Fixtures> getAllFixtures();
    @GET("teams/66/players")
    Call<Players> getAllPlayers();

}
