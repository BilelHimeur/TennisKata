package com.kata.tennis.services;

import com.kata.tennis.model.GameScore;
import com.kata.tennis.model.MatchStatus;
import com.kata.tennis.model.Player;
import com.kata.tennis.model.ScoreHolder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class TennisGame {

    public final String playerOneName;
    public final String playerTwoName;
    public List<ScoreHolder> setsScore = new ArrayList<>();
    public ScoreHolder currentGameScore = new ScoreHolder(0, 0);
    public MatchStatus matchStatus = MatchStatus.IN_PROGRESS;

    public static TennisGame score(Player playerWhoScored, TennisGame tennisGameCurrentStatus) {
        GameScore playerOneGameScore = GameScore.getByValue(tennisGameCurrentStatus.getCurrentGameScore().getPlayerOneScore());
        GameScore playerTwoGameScore = GameScore.getByValue(tennisGameCurrentStatus.getCurrentGameScore().getPlayerTwoScore());
        ScoreHolder scoreHolder = GameScoreService.score(playerOneGameScore, playerTwoGameScore, playerWhoScored);
        tennisGameCurrentStatus.setCurrentGameScore(scoreHolder);
        return tennisGameCurrentStatus;
    }

    public ScoreHolder getCurrentSetScore() {
        if (this.setsScore.size() != 0)
            return this.setsScore.get(this.setsScore.size() - 1);
        return new ScoreHolder(0, 0);
    }

    public void setCurrentSetScore(ScoreHolder currentSetScore){
        this.setsScore.add(currentSetScore);
    }
}
