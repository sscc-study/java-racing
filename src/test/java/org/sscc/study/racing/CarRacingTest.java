package org.sscc.study.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sscc.study.racing.CarRacing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @Test
    @DisplayName("전진 횟수가 주어진 값 사이로 들어오는 지 확인")
    public void random() {
        CarRacing carRacing = new CarRacing(4, 10);
        carRacing.raceStart();
        List<Car> result = carRacing.getResult();
        for (Car car : result) {
            assertThat(car.getCar().length()).isGreaterThanOrEqualTo(0)
                    .isLessThanOrEqualTo(10);
        }
    }

    @Test
    @DisplayName("항상 참일때")
    public void nonrandom() {
        Cars.randomStrategy = new NonRandom();
        CarRacing carRacing = new CarRacing(1, 5);
        carRacing.raceStart();
        List<Car> result = carRacing.getResult();
        assertThat(result.get(0).getCar()).isEqualTo("-----");
    }
}