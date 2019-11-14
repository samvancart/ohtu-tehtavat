package ohtu;

import java.util.Objects;

public class Player implements Comparable<Player> {

    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }

    public String getTeam() {
        return team;
    }

    public Integer getPoints() {
        return goals + assists;
    }

    public boolean isNationality(String nationality) {
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return String.format("%-20s", name) + " " + team + " " + String.format("%2d", goals) + " +" + String.format("%2d", assists) + " = " + getPoints();
    }

    @Override
    public int compareTo(Player t) {
        if (Objects.equals(t.getPoints(), this.getPoints())) {
            return t.getGoals() - this.getGoals();
        } else {
            return t.getPoints() - this.getPoints();
        }
    }

}
