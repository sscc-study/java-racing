import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @DisplayName("덧셈 테스트")
    @Test
    void add() {
        inputHandling("2 + 3 + 4 + 5");
        assertThat(calculator.execute()).isEqualTo(14);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subtract() {
        inputHandling("10 - 9 - 8 - 7");
        assertThat(calculator.execute()).isEqualTo(-14);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiply() {
        inputHandling("2 * 3 * 4 * 5");
        assertThat(calculator.execute()).isEqualTo(120);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divide() {
        inputHandling("20 / 5 / 2 / 2");
        assertThat(calculator.execute()).isEqualTo(1);
    }
}