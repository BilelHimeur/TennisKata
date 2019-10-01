package com.kata.tennis.services;

import com.kata.tennis.model.MatchStatus;
import com.sun.tools.javac.util.Pair;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class TennisGame {

    public final String playerOneName;
    public final String playerTwoName;
    public List<Pair<Integer, Integer>> scores = new ArrayList<>();
    public Pair<Integer, Integer> currentGameScore = new Pair<>(0,0);
    public MatchStatus matchStatus = MatchStatus.IN_PROGRESS;


}
