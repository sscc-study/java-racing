import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    void 더하기_테스트() {
        // given
        String test = "1 + 2 + 3";
        int expected = 6;

        // when
        int result = calculator.run(test);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 뺄셈_테스트() {
        // given
        String test = "7 - 2 - 3";
        int expected = 2;

        // when
        int result = calculator.run(test);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 곱하기_테스트() {
        // given
        String test = "7 * 2 * 3";
        int expected = 42;

        // when
        int result = calculator.run(test);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 나누기_테스트() {
        // given
        String test = "20 / 2 / 5";
        int expected = 2;

        // when
        int result = calculator.run(test);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 공백문자_테스트() {
        // given
        String test = "    ";

        // then
        assertThatThrownBy(() -> {
            calculator.run(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_없을때_테스트() {
        // given
        String test = "";

        // then
        assertThatThrownBy(() -> {
            calculator.run(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_null일때_테스트() {
        // given
        String test = null;

        // then
        assertThatThrownBy(() -> {
            calculator.run(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 순서대로_계산되는_지_확인() {
        // given
        String test = "2 + 3 * 4 / 2";
        int expected = 10;

        // when
        int result = calculator.run(test);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 사칙연산기호_확인_테스트() {
        // given
        String test = "1 + 2 % 5";

        // then
        assertThatThrownBy(() -> {
            calculator.run(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}