package org.sscc.study.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @Test
    @DisplayName("전진 횟수가 주어진 값 사이로 들어오는 지 확인")
    public void random() {
        CarRacing carRacing = new CarRacing(1, 5);
        carRacing.raceStart(new RandomMove());
        String result = carRacing.getResult();
        assertThat(result.length()).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(5);
    }

    @Test
    @DisplayName("항상 참일때")
    public void nonrandom() {
        CarRacing carRacing = new CarRacing(1, 5);
        carRacing.raceStart(new AlwaysMove());
        String result = carRacing.getResult();
        assertThat(result).isEqualTo("-----");
    }
}