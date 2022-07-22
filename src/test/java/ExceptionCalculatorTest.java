import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionCalculatorTest{
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("입력 값이 null 또는 빈 공백 문자인지 테스트")
    void inputformExceptiontest(){
        String str = "";
        assertThatThrownBy(()->{
            calculator.calculateUser(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산 기호 테스트")
    void operatorExceptiontest(){
        String str = "2 $ 3";
        assertThatThrownBy(()->{
            calculator.calculateUser(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}