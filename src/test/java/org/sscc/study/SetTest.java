package org.sscc.study;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("should_ReturnSetSize")
    void should_ReturnSetSize() {
        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("should_TestIfSetHasValue_ForValuesInSet")
    @ValueSource(ints = {1, 2, 3})
    void should_TestIfSetHasValue_ForValuesInSet(int value) {
        assertTrue(numbers.contains(value));
    }

    @ParameterizedTest
    @DisplayName("should_TestIfSetHasValue_ForSomeIntegers")
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void should_TestIfSetHasValue_ForSomeIntegers(int value, boolean hasValue) {
        assertThat(numbers.contains(value)).isEqualTo(hasValue);
    }
}