package com.kata.tennis.services;

import com.kata.tennis.model.GameScore;
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
        // when
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // then
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(15, 0)));
        assertThat(tennisGameNextStatus.getMatchStatus(), is(MatchStatus.IN_PROGRESS));
    }

    @Test
    public void should_update_set_score_when_there_is_game_winner() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        tennisGame.setCurrentGameScore(new ScoreHolder(GameScore.ADVANTEGE.getGameScoreValue(), GameScore.FIFTEEN.getGameScoreValue()));
        tennisGame.setCurrentSetScore( new ScoreHolder(0, 0));
        Player playerWhoScored = Player.PLAYER_ONE;
        // when
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // then
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(0, 0)));
        assertThat(tennisGameNextStatus.getCurrentSetScore(), is(new ScoreHolder(1, 0)));
    }

    @Test
    public void should_update_match_score_when_there_is_set_winner() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        tennisGame.setCurrentGameScore(new ScoreHolder(GameScore.ADVANTEGE.getGameScoreValue(), GameScore.FIFTEEN.getGameScoreValue()));
        tennisGame.setCurrentSetScore( new ScoreHolder(5, 3));
        tennisGame.setCurrentMatchScore( new ScoreHolder(0, 0));
        Player playerWhoScored = Player.PLAYER_ONE;
        // when
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // then
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(0, 0)));
        assertThat(tennisGameNextStatus.getCurrentSetScore(), is(new ScoreHolder(0, 0)));
        assertThat(tennisGameNextStatus.getCurrentMatchScore(), is(new ScoreHolder(1, 0)));
    }

    @Test
    public void should_update_game_score_when_there_is_tie_break() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        tennisGame.setCurrentGameScore(new ScoreHolder(4, 3));
        tennisGame.setCurrentSetScore( new ScoreHolder(6, 6));
        Player playerWhoScored = Player.PLAYER_ONE;
        // when
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // then
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(5, 3)));
    }

    @Test
    public void should_update_match_score_when_there_is_tie_break_winner() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        tennisGame.setCurrentGameScore(new ScoreHolder(7, 3));
        tennisGame.setCurrentSetScore( new ScoreHolder(6, 6));
        tennisGame.setCurrentMatchScore( new ScoreHolder(1, 1));
        Player playerWhoScored = Player.PLAYER_ONE;
        // when
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // then
        assertThat(tennisGameNextStatus.getCurrentGameScore(), is(new ScoreHolder(0, 0)));
        assertThat(tennisGameNextStatus.getCurrentSetScore(), is(new ScoreHolder(0, 0)));
        assertThat(tennisGameNextStatus.getCurrentMatchScore(), is(new ScoreHolder(2, 1)));
    }

    @Test
    public void should_update_match_status_to_wining_player() {
        // given
        TennisGame tennisGame = new TennisGame(PLAYER_ONE_NAME, PLAYER_TWO_NAME);
        tennisGame.setCurrentMatchScore( new ScoreHolder(3, 1));
        Player playerWhoScored = Player.PLAYER_ONE;
        // when
        TennisGame tennisGameNextStatus = score(playerWhoScored, tennisGame);
        // then
        assertThat(tennisGameNextStatus.getMatchStatus(), is(MatchStatus.PLAYER_ONE_WINS));
    }
}
