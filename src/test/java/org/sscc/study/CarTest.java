package org.sscc.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
            "4, 4"
    })
    @DisplayName("생성자 호출 후 현재 위치 테스트")
    void should_ReturnCurrentPosition(int position, int currentPosition) {
        //given

        //when
        Car car = new Car(new GameCondition(), position);
        //then
        assertThat(car.currentPosition()).isEqualTo(currentPosition);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "2, 3",
            "3, 4",
            "4, 5"
    })
    @DisplayName("전진 후 현재 위치 테스트")
    void should_Move_WhenMovable(int position, int currentPosition) {
        //given
        Car car = new Car(new GameCondition(), position);
        //when
        car.moveForward();
        //then
        assertThat(car.currentPosition()).isBetween(position, currentPosition);
    }
}