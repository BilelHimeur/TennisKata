package com.kata.tennis.services;

import com.kata.tennis.model.MatchStatus;
import org.junit.Test;

import java.util.Optional;

import static com.kata.tennis.services.MatchScoreService.matchWinner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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

    @Test
    public void should_return_player_who_has_three_sets_won_first() {
        // given
        int playerOneSetScore = 2;
        int playerTwoSetScore = 3;
        MatchStatus winner = MatchStatus.PLAYER_TWO_WINS;
        // when
        Optional maybeWinner = matchWinner(playerOneSetScore, playerTwoSetScore);
        // then
        assertThat(maybeWinner.isPresent(), is(true));
        assertThat(maybeWinner.get(), is(winner));
    }
}
