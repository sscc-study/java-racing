import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionCalculatorTest {

    Calculator calculator = new Calculator();

    public static void inputHandling(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    @DisplayName("공백이 입력된 경우")
    @Test
    void inputBlank() {
        inputHandling("");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("공백은 입력할 수 없습니다.");
    }

    @DisplayName("잘못된 계산형식")
    @Test
    void wrongInput() {
        inputHandling("1 * 0 /");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(ArrayIndexOutOfBoundsException.class)
                .hasMessage("입력이 잘못되었습니다.");
    }

    @DisplayName("잘못된 연산자가 입력된 경우")
    @Test
    void wrongOperator() {
        inputHandling("1 a 2");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 연산자입니다.");
    }

    @DisplayName("잘못된 피연산자가 입력된 경우")
    @Test
    void wrongOperand() {
        inputHandling("ㄱ * 2");
        assertThatThrownBy(() -> calculator.execute())
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자 자리에 다른 문자를 입력했거나 띄워쓰기가 잘못되었습니다.");
    }

}