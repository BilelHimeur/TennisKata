package com.kata.tennis.services;

import org.junit.Test;

import java.util.Optional;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static com.kata.tennis.services.SetScoreService.setWinner;

public class SetScoreServiceTest {

    @Test
    public void should_return_no_winner_when_both_are_less_than_6() {
        // given
        int playerOneScore = 4;
        int playerTwoScore = 2;
        // when
        Optional winner = setWinner(playerOneScore, playerTwoScore);
        // then
        assertThat(winner.isPresent(), is(false));
    }
}
