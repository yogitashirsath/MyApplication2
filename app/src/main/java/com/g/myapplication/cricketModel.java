package com.g.myapplication;

public class cricketModel {
    String unique_id;
    String team1;
    String team2;
    String type;
    String squad;
    String toss_winner_team;
    String winner_team;
    String matchStarted;

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public String getToss_winner_team() {
        return toss_winner_team;
    }

    public void setToss_winner_team(String toss_winner_team) {
        this.toss_winner_team = toss_winner_team;
    }

    public String getWinner_team() {
        return winner_team;
    }

    public void setWinner_team(String winner_team) {
        this.winner_team = winner_team;
    }

    public String getMatchStarted() {
        return matchStarted;
    }

    public void setMatchStarted(String matchStarted) {
        this.matchStarted = matchStarted;
    }

    public cricketModel(String unique_id,String team1,String team2,String type,String squad,String toss_winner_team,String winner_team,String matchStarted) {
        this.unique_id = unique_id;
        this.team1 = team1;
        this.team2 = team2;
        this.type = type;
        this.squad = squad;
        this.toss_winner_team = toss_winner_team;
        this.winner_team = winner_team;
        this.matchStarted = matchStarted;
    }
}