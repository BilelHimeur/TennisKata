package com.kata.tennis.services;

import com.kata.tennis.model.GameScore;
import com.kata.tennis.model.Player;

import java.util.Optional;

public class GameScoreService {
    public static Optional<Player> gameWinner (GameScore playerOneScore, GameScore playerTwoScore) {
        if (GameScore.FORTY.equals(playerOneScore))
            return Optional.of(Player.PLAYER_ONE);
        if (GameScore.FORTY.equals(playerTwoScore))
            return Optional.of(Player.PLAYER_TWO);
        return Optional.empty();
    }
}
