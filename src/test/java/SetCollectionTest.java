import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void size(){
        int setsize = numbers.size();
        assertThat(setsize).isEqualTo(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void parameterizedTest(int number){
        assertThat(numbers.contains(number)).isTrue();
    }

    @Test
    void parameterizedTest_1(){
        assertThat(numbers.contains(1)).isEqualTo(true);
        assertThat(numbers.contains(2)).isEqualTo(true);
        assertThat(numbers.contains(3)).isEqualTo(true);
        assertThat(numbers.contains(true)).isEqualTo(false);
        assertThat(numbers.contains(4)).isEqualTo(false);
        assertThat(numbers.contains(5)).isEqualTo(false);
    }


}

