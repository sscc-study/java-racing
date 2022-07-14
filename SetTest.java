import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUP(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("set size test")
    @Test
    public void SizeTest(){
        int test = numbers.size();

        assertThat(test).isEqualTo(3);
    }

    @DisplayName("set contains test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void ContainsTest(int test) {
        assertThat(numbers).contains(test);
    }

    @DisplayName("set contains test (입력값에 따라 결과값 변동)")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void ContainsTestInput(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
