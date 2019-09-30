package com.kata.tennis.services;

import com.kata.tennis.model.GameScore;
import com.kata.tennis.model.Player;

import java.util.Optional;

public class GameScoreService {
    public static Optional<Player> gameWinner(GameScore playerOneScore, GameScore playerTwoScore) {
        if (isDeuce(playerOneScore, playerTwoScore))
            return Optional.empty();
        if (GameScore.FORTY.equals(playerOneScore))
            return Optional.of(Player.PLAYER_ONE);
        if (GameScore.FORTY.equals(playerTwoScore))
            return Optional.of(Player.PLAYER_TWO);
        return Optional.empty();
    }

    public static boolean isDeuce(GameScore playerOneScore, GameScore playerTwoScore) {
        if (GameScore.FORTY.equals(playerOneScore) && GameScore.FORTY.equals(playerTwoScore) ||
                GameScore.ADVANTEGE.equals(playerOneScore) && GameScore.ADVANTEGE.equals(playerTwoScore))
            return true;
        return false;
    }

    public static Optional<Player> gameWinner(GameScore playerOneScore, GameScore playerTwoScore, Player playerWhoScored) {
        if (playerWhoScored == null) {
            gameWinner(playerOneScore, playerTwoScore);
        } else {
            if (GameScore.ADVANTEGE.equals(playerOneScore) && Player.PLAYER_ONE.equals(playerWhoScored))
                return Optional.of(Player.PLAYER_ONE);
            if (GameScore.ADVANTEGE.equals(playerTwoScore) && Player.PLAYER_TWO.equals(playerWhoScored))
                return Optional.of(Player.PLAYER_TWO);
        }
        return Optional.empty();
    }
}
