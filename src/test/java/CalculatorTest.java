import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("더하기 테스트")
    void addtest(){
        assertThat(5).isEqualTo(calculator.calculateUser("3 + 2"));
    }

    @Test
    @DisplayName("빼기 테스트")
    void substracttest(){
        assertThat(5).isEqualTo(calculator.calculateUser("12 - 7"));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplytest(){
        assertThat(5).isEqualTo(calculator.calculateUser("5 * 1"));
    }

    @Test
    @DisplayName("나누기 테스트")
    void dividetest(){
        assertThat(5).isEqualTo(calculator.calculateUser("25 / 5"));
    }

    @Test
    @DisplayName("문자열 나누기 테스트")
    void seperatetest(){
        String str = "3 + 2";
        String[] result = {"3", "+", "2"};
        assertThat(result).isEqualTo(calculator.seperate(str));
    }

    @Test
    @DisplayName("사칙 연산 모두 포함하는 테스트")
    void allarithmetictest(){
        assertThat(5).isEqualTo(calculator.calculateUser("3 + 12 - 5 * 4 / 8"));
    }
}
