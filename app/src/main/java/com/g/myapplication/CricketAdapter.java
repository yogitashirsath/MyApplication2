package com.g.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CricketAdapter extends RecyclerView.Adapter<CricketAdapter.ViewHolder> {
    public CricketAdapter(List<cricketModel> cricketModelList,Context context) {
        this.cricketModelList = cricketModelList;
        this.context = context;
    }

    private List<cricketModel> cricketModelList;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int position ) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cricketitem,viewGroup,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
cricketModel cricketModel=cricketModelList.get(position);
         holder.id.setText(cricketModel.getUnique_id());
        holder.team1.setText(cricketModel.getUnique_id());
        holder.team2.setText(cricketModel.getTeam1());
        holder.type.setText(cricketModel.getTeam2());
        holder.squad.setText(cricketModel.getSquad());
        holder.tosswinnerteam.setText(cricketModel.getToss_winner_team());
       holder.winnerteam.setText(cricketModel.getWinner_team());
        holder.matchsatrted.setText(cricketModel.getMatchStarted());
    }

    @Override
    public int getItemCount() {
        return cricketModelList.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView id ,team1,team2,type,squad,tosswinnerteam,winnerteam,matchsatrted;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.textViewID);
            team1=itemView.findViewById(R.id.textViewtem1);
            team2=itemView.findViewById(R.id.textViewtem2);
            type=itemView.findViewById(R.id.textViewtype);
            squad=itemView.findViewById(R.id.textViewsquad);
           tosswinnerteam=itemView.findViewById(R.id.textViewtoss_winner_team);
            winnerteam=itemView.findViewById(R.id.textViewwinner_team);
           matchsatrted=itemView.findViewById(R.id.textViewmatchStarted);

        }
    }
}