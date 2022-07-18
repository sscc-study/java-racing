import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {
    @Test
    public void 덧셈연산자_테스트() {
        int result = Operator.checkOperation(1, 3, "+");
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 뺄셈연산자_테스트() {
        int result = Operator.checkOperation(1, 3, "-");
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void 곱셈연산자_테스트() {
        int result = Operator.checkOperation(2, 4, "*");
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void 나눗셈연산자_테스트() {
        int result = Operator.checkOperation(4, 2, "/");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 비정상연산자_테스트() {
        assertThatThrownBy(() -> {
            Operator.checkOperation(5, 1, "^");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}