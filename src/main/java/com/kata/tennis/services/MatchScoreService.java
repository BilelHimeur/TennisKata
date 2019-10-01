package com.kata.tennis.services;

import com.kata.tennis.model.MatchStatus;
import com.kata.tennis.model.Player;
import com.kata.tennis.model.ScoreHolder;

import java.util.Optional;

public class MatchScoreService {

    public static Optional<MatchStatus> matchWinner(int playerOneSetScore, int playerTwoSetScore) {
        if (playerOneSetScore < 3 && playerTwoSetScore < 3) {
            return Optional.of(MatchStatus.IN_PROGRESS);
        } else {
            if (playerOneSetScore > playerTwoSetScore)
                return Optional.of(MatchStatus.PLAYER_ONE_WINS);
            return Optional.of(MatchStatus.PLAYER_TWO_WINS);
        }
    }

    public static ScoreHolder score(int currentPlayerOneMatchScore, int currentPlayerTwoMatchScore, Player playerWhoScored) {
        if (Player.PLAYER_ONE.equals(playerWhoScored))
            currentPlayerOneMatchScore ++;
        else
            currentPlayerTwoMatchScore ++;
        return new ScoreHolder(currentPlayerOneMatchScore, currentPlayerTwoMatchScore);
    }
}
