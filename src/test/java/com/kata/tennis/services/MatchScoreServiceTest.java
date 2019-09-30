package com.kata.tennis.services;

import org.junit.Test;

import java.util.Optional;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static com.kata.tennis.services.MatchScoreService.matchWinner;

public class MatchScoreServiceTest {

    @Test
    public void should_return_no_winner_when_both_set_scores_less_than_3() {
        // given
        int playerOneSetScore = 1;
        int playerTwoSetScore = 2;
        // when
        Optional maybeWinner = matchWinner(playerOneSetScore, playerTwoSetScore);
        // then
        assertThat(maybeWinner.isPresent(), is(false));
    }
}
