import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set크기 확인")
    @Test
    public void testSize(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 해당하는 값이 존재하는 지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void testExist(int expected){
        assertThat(numbers).contains(expected);
    }

    @DisplayName("입력값에 따라결과값을 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:True", "2:True","3:True", "4:False", "5:False"}, delimiter = ':')
    public void testExistDepends(int argument, boolean expected){
        assertThat(numbers.contains(argument)).isEqualTo(expected);
    }

}
