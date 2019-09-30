package com.kata.tennis.services;

import com.kata.tennis.model.Player;

import java.util.Optional;

public class SetScoreService {

    public static Optional<Player> setWinner(int playerOneScore, int playerTwoScore) {
        if (playerOneScore < 6 && playerTwoScore < 6)
            return Optional.empty();
        return Optional.empty();
    }
}
