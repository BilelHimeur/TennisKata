package com.kata.tennis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreHolder {
    public int playerOneScore;
    public int playerTwoScore;
}
