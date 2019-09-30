package com.kata.tennis.services;

import com.kata.tennis.model.Player;

import java.util.Optional;

public class MatchScoreService {

    public static Optional<Player> matchWinner (int playerOneSetScore, int playerTwoSetScore) {
        if (playerOneSetScore < 3 && playerTwoSetScore < 3) {
            return Optional.empty();
        } else {
            if (playerOneSetScore > playerTwoSetScore)
                return Optional.of(Player.PLAYER_ONE);
            return Optional.of(Player.PLAYER_TWO);
        }
    }
}
