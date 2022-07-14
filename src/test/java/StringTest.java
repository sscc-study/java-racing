import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("조건에 맞춘 split 수행하는 테스트")
    public void split() {
        String[] first = "1,2".split(",");
        String[] second = "1,".split(",");

        assertThat(first).contains("1", "2");
        assertThat(second).containsExactly("1");
    }

    @Test
    @DisplayName("() 제거하는 테스트")
    public void subString() {
        String basic = "(1,2)";
        String result = basic.substring(1, basic.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 문자열이 주어졌을 때 특정 위치의 문자 가져오는 테스트")
    public void charAtTest() {
        String str = "abc";

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}
