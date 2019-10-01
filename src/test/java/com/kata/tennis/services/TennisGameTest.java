package com.kata.tennis.services;

import com.kata.tennis.model.MatchStatus;
import com.kata.tennis.model.Player;
import com.kata.tennis.model.ScoreHolder;
import org.junit.Test;

import static com.kata.tennis.services.TennisGame.score;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TennisGameTest {
    private final static String PLAYER_ONE_NAME = "player 1";
    private final static String PLAYER_TWO_NAME = "player 2";

    @Test
    public void should_update_only_current_game_score() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        Player playerWhoScored = Player.PLAYER_ONE;
        // then
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // when
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(15, 0)));
        assertThat(tennisGameNextStatus.getMatchStatus(), is(MatchStatus.IN_PROGRESS));
    }

    @Test
    public void should_update_set_score_when_there_is_game_winner() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        Player playerWhoScored = Player.PLAYER_ONE;
        // then
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        tennisGameNextStatus.setCurrentGameScore(new ScoreHolder(40, 15));
        ScoreHolder currentSetScore = new ScoreHolder(0, 0);
        tennisGameNextStatus.setCurrentSetScore(currentSetScore);
        // when
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(0, 0)));
        assertThat(tennisGameNextStatus.getCurrentSetScore(), is(new ScoreHolder(1, 0)));
    }
}
