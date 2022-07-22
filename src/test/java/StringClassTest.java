import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringClassTest {
    @Test
    @DisplayName("split 테스트")
    public void split(){
        String[] str = "1,2".split(",");
        assertThat(str).contains("1","2");

        str="1".split(",");
        assertThat(str).containsExactly("1");
    }

    @Test
    @DisplayName("()제거하기")
    public void substring(){
        String values = "(1,2)".substring(1,5);
        assertThat(values).contains("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 학습 테스트")
    public void charAt(){
        String str = "abc";
        char value = str.charAt(2);
        assertThat(value).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(()->{"abc".charAt(4);});
    }
}