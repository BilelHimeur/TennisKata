package com.kata.tennis.services;

import com.kata.tennis.model.GameScore;
import com.kata.tennis.model.Player;
import org.junit.Test;

import java.util.Optional;

import static com.kata.tennis.services.GameScoreService.gameWinner;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameScoreServiceTest {

    @Test
    public void should_return_the_player_with_the_score_forty() {
        // given
        GameScore playerOneScore = GameScore.FORTY;
        GameScore playerTwoScore = GameScore.ZERO;
        // when
        Optional<Player> optionalWinner = gameWinner(playerOneScore, playerTwoScore);
        // then
        assertThat(true, is(optionalWinner.isPresent()));
        assertThat(Player.PLAYER_ONE, is(optionalWinner.get()));
    }
}
