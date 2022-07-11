package org.sscc.study;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

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
    void testSetSize() {
        //when
        int size = numbers.size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testIfSetContainsValue(int value) {
        assertTrue(numbers.contains(value));
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "3, true",
            "4, false",
            "5, false"
    })
    void testIfSetContainsValue(int value, boolean hasValue) {
        assertThat(numbers.contains(value)).isEqualTo(hasValue);
    }
}