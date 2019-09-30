package com.kata.tennis.services;

import com.kata.tennis.model.Player;
import org.junit.Test;

import java.util.Optional;

import static com.kata.tennis.services.SetScoreService.isSetScoreTieBreak;
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

    @Test
    public void should_return_winner_if_he_scores_at_least_6_and_2_more_than_opponent() {
        // given
        int playerOneScore = 7;
        int playerTwoScore = 5;
        Player winner = Player.PLAYER_ONE;
        // when
        Optional maybeWinner = setWinner(playerOneScore, playerTwoScore);
        // then
        assertThat(maybeWinner.isPresent(), is(true));
        assertThat(maybeWinner.get(), is(winner));
    }

    @Test
    public void should_return_true_if_tie_break_of_set_score() {
        // given
        int playerOneScore = 6;
        int playerTwoScore = 6;
        // when
        boolean isTieBreak = isSetScoreTieBreak(playerOneScore, playerTwoScore);
        // then
        assertThat(isTieBreak, is(true));
    }

    @Test
    public void should_return_winner_of_tie_break_as_set_winner() {
        // given
        int playerOneTieBreakScore = 13;
        int playerTwoTieBreakScore = 15;
        Player winner = Player.PLAYER_TWO;
        // when
        Optional maybeWinner = setWinner(playerOneTieBreakScore, playerTwoTieBreakScore);
        // then
        assertThat(maybeWinner.isPresent(), is(true));
        assertThat(maybeWinner.get(), is(winner));
    }
}
