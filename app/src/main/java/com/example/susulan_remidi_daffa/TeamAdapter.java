package com.example.susulan_remidi_daffa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {
    private List<Team> teamList;

    public TeamAdapter(List<Team> teamList) {
        this.teamList = teamList;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = teamList.get(position);
        holder.tvNamaTim.setText(team.strTeam);
        holder.tvStadium.setText(team.strStadium);
        holder.tvidTeam.setText(team.idTeam);
        holder.tvstrLeague4.setText(team.strLeague4);
        holder.tvstrLocation.setText(team.strLocation);

        Glide.with(holder.itemView.getContext())
                .load(team.strBadge)
                .into(holder.imgBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaTim, tvStadium, tvidTeam, tvstrLeague4, tvstrLocation;
        ImageView imgBadge;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaTim = itemView.findViewById(R.id.tvNamaTimPmr);
            tvStadium = itemView.findViewById(R.id.tvStadiumPmr);
            imgBadge = itemView.findViewById(R.id.GambarBadgePmr);
            tvidTeam = itemView.findViewById(R.id.tvidTeam);
            tvstrLeague4 = itemView.findViewById(R.id.tvstrLeague4);
            tvstrLocation = itemView.findViewById(R.id.tvstrLocation);
        }
    }
}
