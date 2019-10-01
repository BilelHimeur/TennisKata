package com.kata.tennis.model;

import lombok.Getter;

@Getter
public enum GameScore {
    ZERO(0),
    FIFTEEN(15),
    THERTY(30),
    FORTY(40),
    DEUCE(50),
    ADVANTEGE(60);

    private int gameScoreValue;

    GameScore(int gameScoreValue) {
        this.gameScoreValue = gameScoreValue;
    }
}
