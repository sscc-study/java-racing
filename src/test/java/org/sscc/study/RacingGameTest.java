package org.sscc.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
            "4, 4",
            "5, 5"
    })
    @DisplayName("레이싱 게임 진행 결과 테스트")
    void gameResult(int carCount, int roundCount) {
        //given
        RacingGame racingGame = new RacingGame(carCount, roundCount);
        //when
        List<?> roundResults = racingGame.gameResult();
        //then
        assertThat(roundResults).isInstanceOf(Vector.class);
        for (int i = 0; i < roundCount; i++) {
            assertThat(roundResults.get(i)).isInstanceOf(Roster.class);
        }
    }
}