import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 크기 확인")
    void size(){
        int setsize = numbers.size();
        assertThat(setsize).isEqualTo(3);
    }

    @DisplayName("Set 원소 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void parameterizedTest(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @Test
    @DisplayName("입력값에 따른 Set 원소 확인")
    void parameterizedTest_1(){
        assertThat(numbers.contains(1)).isEqualTo(true);
        assertThat(numbers.contains(2)).isEqualTo(true);
        assertThat(numbers.contains(3)).isEqualTo(true);
        assertThat(numbers.contains(true)).isEqualTo(false);
        assertThat(numbers.contains(4)).isEqualTo(false);
        assertThat(numbers.contains(5)).isEqualTo(false);
    }


}

