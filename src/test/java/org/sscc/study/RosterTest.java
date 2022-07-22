package org.sscc.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class RosterTest {

    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            3,
            4,
            5
    })
    @DisplayName("Roster 사이즈 테스트")
    void should_ReturnRosterSize(int carCount) {
        //given
        Roster roster = new Roster(carCount);
        //when
        Integer size = roster.rosterSize();
        //then
        assertThat(size).isEqualTo(carCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            3,
            4,
            5
    })
    @DisplayName("Car로 구성된 Roster 객체 테스트")
    void should_ReturnRosterReferenceThatContainsCar(int carCount) {
        //given
        Roster roster = new Roster(carCount);
        //when
        List<Car> rosterReference = roster.roster();
        //then
        for (int i = 0; i < carCount; i++) {
            assertThat(rosterReference.get(i)).isInstanceOf(Car.class);
        }
    }
}