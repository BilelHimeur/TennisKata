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
    public void Should_update_only_current_game_score() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        Player playerWhoScored = Player.PLAYER_ONE;
        // then
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // when
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(15, 0)));
        assertThat(tennisGameNextStatus.getMatchStatus(), is(MatchStatus.IN_PROGRESS));
    }
}
