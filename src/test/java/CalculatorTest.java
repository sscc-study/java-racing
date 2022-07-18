import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator;

    @Test
    void 더하기_테스트() {
        // given
        String test = "1 + 2 + 3";
        int expected = 6;

        // when
        calculator = new Calculator(test);
        int result = calculator.run();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 뺄셈_테스트() {
        // given
        String test = "7 - 2 - 3";
        int expected = 2;

        // when
        calculator = new Calculator(test);
        int result = calculator.run();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 곱하기_테스트() {
        // given
        String test = "7 * 2 * 3";
        int expected = 42;

        // when
        calculator = new Calculator(test);
        int result = calculator.run();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 나누기_테스트() {
        // given
        String test = "20 / 2 / 5";
        int expected = 2;

        // when
        calculator = new Calculator(test);
        int result = calculator.run();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 공백문자_테스트() {
        // given
        String test = "    ";

        // then
        assertThatThrownBy(() -> {
            calculator = new Calculator(test);
            calculator.run();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_없을때_테스트() {
        // given
        String test = "";

        // then
        assertThatThrownBy(() -> {
            calculator = new Calculator(test);
            calculator.run();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_null일때_테스트() {
        // given
        String test = null;

        // then
        assertThatThrownBy(() -> {
            calculator = new Calculator(test);
            calculator.run();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 순서대로_계산되는_지_확인() {
        // given
        String test = "2 + 3 * 4 / 2";
        int expected = 10;

        // when
        calculator = new Calculator(test);
        int result = calculator.run();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 사칙연산기호_확인_테스트() {
        // given
        String test = "1 + 2 % 5";

        // then
        assertThatThrownBy(() -> {
            calculator = new Calculator(test);
            calculator.run();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}