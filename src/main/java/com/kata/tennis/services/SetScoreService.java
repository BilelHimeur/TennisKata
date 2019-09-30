package com.kata.tennis.services;

import com.kata.tennis.model.Player;

import java.util.Optional;

import static java.lang.Math.abs;

public class SetScoreService {

    public static Optional<Player> setWinner(int playerOneScore, int playerTwoScore) {
        int setScoreDifference = abs(playerOneScore - playerTwoScore);
        if (playerOneScore < 6 && playerTwoScore < 6) {
            return Optional.empty();
        } else {
            if (setScoreDifference >= 2) {
                if (playerOneScore > playerTwoScore)
                    return Optional.of(Player.PLAYER_ONE);
                if (playerTwoScore > playerOneScore)
                    return Optional.of(Player.PLAYER_TWO);
            }
        }
        return Optional.empty();
    }

    public static boolean isSetScoreTieBreak(int playerOneScore, int playerTwoScore) {
        if (playerOneScore == playerTwoScore && playerOneScore == 6)
            return true;
        return false;
    }
    }
