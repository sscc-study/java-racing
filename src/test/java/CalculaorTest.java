import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class CalculatorTest {

    private final Calculator strcalculator = new Calculator();

    @Test
    void plusTest() {
        assertThat(strcalculator.plus(2, "3")).isEqualTo(5);
    }

    @Test
    void minusTest() {
        assertThat(strcalculator.minus(10, "3")).isEqualTo(7);
    }

    @Test
    void multiplyTest() {
        assertThat(strcalculator.multiply(2, "5")).isEqualTo(10);
    }

    @Test
    void divisionTest() {
        assertThat(strcalculator.division(20, "2")).isEqualTo(10);
    }

    @Test
    void calculateTest(){
        assertThat(strcalculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$"})
    void partCalculatePermittedOperatorTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(strcalculator.partCalculate(input, 5, "5")).isEqualTo(10);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void partCalculateNullInputTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(strcalculator.partCalculate("+", 5, input)).isEqualTo(10);
        });
    }
}