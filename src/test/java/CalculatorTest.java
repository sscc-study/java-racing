import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void init(){
        calculator = new Calculator();
    }

    @DisplayName("add test")
    @Test
    public void addTest(){
        assertThat(10).isEqualTo(calculator.calculate(5, "+", 5));
    }

    @DisplayName("subtract test")
    @Test
    public void subtractTest(){
        assertThat(0).isEqualTo(calculator.calculate(5, "-", 5));
    }

    @DisplayName("multiply test")
    @Test
    public void multiplyTest(){
        assertThat(25).isEqualTo(calculator.calculate(5,"*", 5));
    }

    @DisplayName("divide test")
    @Test
    public void divideTest(){
        assertThat(1).isEqualTo(calculator.calculate(5, "/", 5));
    }

    @DisplayName("입력 값 null/공백 문자 test(toInt)")
    @Test
    public void inputNotExist() {
        assertThatThrownBy(() -> {
            calculator.toInt("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 test(calculate)")
    @Test
    public void OperatorTest(){
        assertThatThrownBy(()->{
            calculator.calculate(1, "%", 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산(calculateFormula) test")
    @Test
    public void resultTest(){
        String formula = "5 + 4 - 3 * 2 / 1";
        String[] formulaSplit = calculator.split(formula);
        assertThat(12).isEqualTo(calculator.calculateFormula(formulaSplit));
    }

    @DisplayName("나누는 숫자가 0인 경우(divide)")
    @Test
    public void divideZeroTest(){
        assertThatThrownBy(()->{
            calculator.calculate(3, "/", 0);
        }).isInstanceOf(ArithmeticException.class);
    }

}
