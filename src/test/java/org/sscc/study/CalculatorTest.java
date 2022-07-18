package org.sscc.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "+ 3 * 7 - 8",
            "4 * 2 - 17 *",
            "3 * + 2",
            "3 + + + 2",
            "3 ^ 5 & 10",
            "5 + 10 - 7 % 3",
            "2 = 22 # 9",
            "77 / 8 / 5 * 5 ! 9",
            "5 +* 10"
    })
    @DisplayName("입력 값에 대해 IllegalArgumentException throw")
    void should_ThrowIllegalArgumentException(String input) {
        calc = new Calculator(input);
        assertThatThrownBy(() -> calc.execute())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "3 + 5 - 10, -2",
            "5 + 10 - 7 * 3, 24",
            "2 - 22 + 9, -11",
            "77 / 8 / 5 * 5 / 9, 0",
            "5 + 10, 15",
            "-1.58 * 77 - 3.8, -125.46",
            "-33 * 1.825 * 99.67 - 303.25 / 44.067, -143"
    })
    @DisplayName("정상 입력 값에 대해 정상 출력")
    void should_ReturnValidOutput_ForValidInput(String input, String output) throws Exception {
        calc = new Calculator(input);
        assertThat(calc.execute()).isEqualTo(output);
    }
}