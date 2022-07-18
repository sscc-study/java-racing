import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @ParameterizedTest
    @DisplayName("올바르지 않은 입력값으로 Exception 테스트")
    @ValueSource(strings = {"9 , 7 ,",
            "3 # 5 / 4", "7 ] 2", ""})
    void exceptionTest(String testInput) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator stringCalculator = new StringCalculator(testInput);
            stringCalculator.splitString();
            stringCalculator.selectOperation();

        });
    }

    @ParameterizedTest
    @DisplayName("올바른 입력값으로 테스트")
    @CsvSource({"6 + 4 / 2,5", "4 * 8 / 3,10",
            "10 - 6 / 2,2", "7 / 2 + 8,11"})
    void calculationTest(String testInput, String testAnswer) {
        StringCalculator stringCalculator = new StringCalculator(testInput);
        stringCalculator.splitString();
        stringCalculator.selectOperation();
        assertThat(stringCalculator.result).isEqualTo(Integer.parseInt(testAnswer));
    }


}