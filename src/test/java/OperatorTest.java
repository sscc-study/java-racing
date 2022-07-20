import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @DisplayName("덧셈 테스트")
    @Test
    void addTest() {
        Operator operator = Operator.findOperator("+");
        int result = operator.operate(1,2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subTest() {
        Operator operator = Operator.findOperator("-");
        int result = operator.operate(2,1);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void mulTest() {
        Operator operator = Operator.findOperator("*");
        int result = operator.operate(1,2);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void divTest() {
        Operator operator = Operator.findOperator("/");
        int result = operator.operate(4,2);
        assertThat(result).isEqualTo(2);
    }


}