package com.kata.tennis.services;

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
    public ScoreHolder currentGameScore = new ScoreHolder(0,0);
    public MatchStatus matchStatus = MatchStatus.IN_PROGRESS;

    public static TennisGame score(Player playerWhoScored, TennisGame tennisGameCurrentStatus) {
        return null;
    }
}
