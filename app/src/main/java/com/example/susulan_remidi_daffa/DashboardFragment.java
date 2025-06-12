package com.example.susulan_remidi_daffa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment{
    private RecyclerView recyclerView2;
    private TeamAdapter teamAdapter;
    private List<Team> teamList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);

        recyclerView2 = view.findViewById(R.id.rvTeamsSpyl);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));

        teamAdapter = new TeamAdapter(teamList);
        recyclerView2.setAdapter(teamAdapter);

        getTeamData();

        return view;
    }

    private void getTeamData() {
        APIService apiService = APIEvents.getEvents().create(APIService.class);
        Call<TeamResponse> call = apiService.getEvents();


        call.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    teamList.clear();
                    teamList.addAll(response.body().getTeams());
                    teamAdapter.notifyDataSetChanged();



                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                Toast.makeText(requireContext(), "Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}

