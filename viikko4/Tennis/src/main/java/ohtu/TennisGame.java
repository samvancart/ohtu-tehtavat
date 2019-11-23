package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private Map<Integer, String> scoreTiedMap;
    private Map<Integer, String> scoreMap;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        scoreTiedMap = new HashMap<>();
        scoreMap = new HashMap<>();
        this.initScoreTiedMapValues();
        this.initScoreMapValues();
    }

    public final void initScoreTiedMapValues() {
        scoreTiedMap.put(0, "Love-All");
        scoreTiedMap.put(1, "Fifteen-All");
        scoreTiedMap.put(2, "Thirty-All");
        scoreTiedMap.put(3, "Forty-All");
        scoreTiedMap.put(4, "Deuce");
    }

    public final void initScoreMapValues() {
        scoreMap.put(0, "Love");
        scoreMap.put(1, "Fifteen");
        scoreMap.put(2, "Thirty");
        scoreMap.put(3, "Forty");
    }

    public boolean isScoreTied() {
        return player1Score == player2Score;
    }

    public boolean isScoreDeuce() {
        return player1Score >= 4 || player2Score >= 4;
    }

    public String getTieScore(int points, String score) {
        if (points >= 4) {
            score = scoreTiedMap.get(4);
        } else {
            score = scoreTiedMap.get(points);
        }
        return score;
    }

    public String getWinner(int score1, int score2, String score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            score = "Advantage " + player1Name;
        } else if (minusResult == -1) {
            score = "Advantage " + player2Name;
        } else if (minusResult >= 2) {
            score = "Win for " + player1Name;
        } else {
            score = "Win for " + player2Name;
        }
        return score;
    }

    public String getInTheLead(int score1, int score2, String score, int tempScore) {
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1Score;
            } else {
                score += "-";
                tempScore = player2Score;
            }
            score += this.scoreMap.get(tempScore);
        }
        return score;
    }

    public void wonPoint(String playerName) {
        if ("player1".equals(playerName)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        String score = "";
        int tempScore = 0;
        if (isScoreTied()) {
            score = this.getTieScore(player1Score, score);
        } else if (isScoreDeuce()) {
            score = this.getWinner(player1Score, player2Score, score);
        } else {
            score = getInTheLead(player1Score, player2Score, score, tempScore);
        }
        return score;
    }
}
