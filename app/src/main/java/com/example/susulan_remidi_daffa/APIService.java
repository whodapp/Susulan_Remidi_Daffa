package com.example.susulan_remidi_daffa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("search_all_teams.php?l=English_Premier_League")
    Call<TeamResponse> getPremierLeagueTeams();

    @GET("search_all_teams.php?l=Spanish_La_Liga") // or choose another valid league
    Call<TeamResponse> getEvents();
}
