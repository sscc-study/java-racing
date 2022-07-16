package org.sscc.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {
    private final Calculator calc = new Calculator();

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("checkIfNullOrEmpty(String) : 입력이 Null이나 Empty일때 IllegalArgumentException throw")
    void should_ThrowIllegalArgumentException_When_InputIsNullOrEmpty(String param) {
        assertThatThrownBy(() -> calc.checkIfNullOrEmpty(param))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("setStringArray(input) : 입력에 대해 문자열 배열 구성")
    void should_setStringArray_forInput() {
        String input = "2 + 3 * 4 / 2";
        calc.setStringArray(input);
        assertThat(calc.stringArray)
                .isNotEmpty()
                .isNotNull()
                .startsWith("2")
                .contains("+")
                .contains("3")
                .contains("*")
                .contains("4")
                .contains("/")
                .endsWith("2");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+ 3 * 7 - 8",
            "4 * 2 - 17 *",
            "3 * + 2",
            "3 ^ 5 & 10",
            "5 + 10 - 7 % 3",
            "2 = 22 # 9",
            "77 / 8 / 5 * 5 ! 9",
            "5 +* 10"
    })
    @DisplayName("calculate(String[]) : 연산자 or 피연산자 오류 시 IllegalArgumentException throw")
    void should_ThrowIllegalArgumentException_ForNoOperandOrOperator(String param) {
        calc.setStringArray(param);
        assertThatThrownBy(() -> calc.calculate(calc.stringArray))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+ 3 * 7 - 8",
            "4 * 2 - 17 *",
            "3 * + 2",
            "3 + + + 2"
    })
    @DisplayName("checkInvalidOperand() : 피연산자 오류 시 IllegalArgumentException throw")
    void should_ThrowIllegalArgumentException_ForNoOperand(String param) {
        calc.setStringArray(param);
        assertThatThrownBy(calc::checkInvalidOperand)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 ^ 5 & 10",
            "5 + 10 - 7 % 3",
            "2 = 22 # 9",
            "77 / 8 / 5 * 5 ! 9",
            "5 +* 10"
    })
    @DisplayName("checkInvalidOperator(index) : 잘못된 연산자에 대해 IllegalArgumentException throw")
    void should_ThrowIllegalArgumentException_ForInvalidOperator(String param) {
        calc.setStringArray(param);
        assertThatThrownBy(calc::checkInvalidOperator)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 ^ 5 & 10",
            "5 + 10 - 7 % 3",
            "2 = 22 # 9",
            "77 / 8 / 5 * 5 ! 9",
            "5 +* 10"
    })
    @DisplayName("hasInvalidOperator(int) : 잘못된 연산자에 대해 true 리턴")
    void should_ReturnTrue_ForInvalidOperator(String param) {
        calc.setStringArray(param);
        int i = 1;
        assertThat(calc.hasInvalidOperator(i)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "3 + 5 - 10",
            "5 + 10 - 7 * 3",
            "2 - 22 + 9",
            "77 / 8 / 5 * 5 / 9",
            "5 + 10"
    })
    @DisplayName("hasInvalidOperator(int) : 올바른 연산자에 대해 False 리턴")
    void should_ReturnFalse_ForValidOperator(String param) {
        calc.setStringArray(param);
        int i = 1;
        assertThat(calc.hasInvalidOperator(i)).isFalse();
    }

    @Test
    @DisplayName("calculate(String[]) : 올바른 입력에 대해 연산 결과 리턴")
    void should_UpdateOutput_When_ValidInput() throws Exception {
        String input = "2 + 3 * 4 / 2";
        calc.setStringArray(input);
        calc.calculate(calc.stringArray);
        assertThat(calc.output).isEqualTo(10);
    }

    @Test
    @DisplayName("calculate(double, String, double) : 사칙연산 결과 리턴")
    void should_ReturnCalculatedValue() throws Exception {
        assertThat(calc.calculate(3, "+", 5)).isEqualTo(8.0);
        assertThat(calc.calculate(3, "-", 5)).isEqualTo(-2.0);
        assertThat(calc.calculate(3, "*", 5)).isEqualTo(15.0);
        assertThat(calc.calculate(3, "/", 5)).isEqualTo(0.0);
        assertThat(calc.calculate(-5, "/", 2)).isEqualTo(-2.0);
    }

    @Test
    @DisplayName("divide(double, double) : 0으로 나눌 때 ArithmeticException throw")
    void should_ThrowArithmeticException_When_DivideByZero() {
        assertThatThrownBy(() -> calc.divide(3, 0))
                .isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            1.33,
            6.0,
            3.14159265359,
            -33.12
    })
    @DisplayName("trimValue() : 결과값을 소수 여섯째 자리에서 절사하고, 0일 경우 미표기하고 문자열로 변환")
    void should_TrimValue(double param) {
        calc.output = param;
        calc.trimValue();
        assertThat(calc.trimmedOutput).isEqualTo(new DecimalFormat("#.######").format(param));
    }
}