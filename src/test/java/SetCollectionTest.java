import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항 1 - size() 테스트")
    @Test
    public void sizeTest() {
        assertThat(numbers.size()).isNotEqualTo(4);
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항 2 - contains() 테스트 ")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void containsTest1(int input) {
        assertThat(numbers).contains(input);
    }

    @DisplayName("요구사항 3 - 입력값에 따라 결과값이 다른 경우의 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsTest2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}

