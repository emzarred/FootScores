package com.example.pc.footscore.Retrofits;


import com.example.pc.footscore.Models.Competition;
import com.example.pc.footscore.Models.Fixtures;
import com.example.pc.footscore.Models.LeagueTable;
import com.example.pc.footscore.Models.Players;
import com.example.pc.footscore.Models.TeamFix;
import com.example.pc.footscore.Models.Teams;
import com.example.pc.footscore.Models.Today;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pc on 25/04/2018.
 */

public interface ApiInterface {
    @GET("competitions/")
    Call<List<Competition>> getAllCompetitions(@Query("year") Integer year);

    @GET("competitions/{Id}/teams")
    Call<Teams> getAllTeams(@Path("Id") Integer Id);

    @GET("competitions/452/leagueTable")
    Call<LeagueTable> getLeagueTable();

    @GET("competitions/452/fixtures?matchday=32")
    Call<Fixtures> getAllFixtures();

    @GET("teams/66/players")
    Call<Players> getAllPlayers();

    @GET("fixtures")
    Call<Today> getAllMatchs();

    @GET("teams/66/fixtures?timeFrame=n14&venue=home")
    Call<TeamFix> getAllFutureFixtures();

}
