import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    //Test case 구현
    @DisplayName("Set 크기 확인 테스트")
    @Test
    public void checkSetSize() {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("1,2,3 값 존재 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void returnTrueNumber(int input) {
        assertThat(numbers.contains(input));
    }

    @DisplayName("값에 따라 T/F 결과가 달라지는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void anotherTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
