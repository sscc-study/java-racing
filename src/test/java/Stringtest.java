import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Stringtest {
    @DisplayName("요구사항 1 - split 테스트")
    @Test
    public void splitTest() {
        String string1 = "1,2";
        String[] result1 = string1.split(",");
        assertThat(result1).contains("1", "2");

        String string2 = "1";
        String[] result2 = string2.split(",");
        assertThat(result2).containsExactly("1");
    }

    @DisplayName("요구사항 2 - substring 테스트")
    @Test
    public void substringTest() {
        String string = "(1,2)";
        String result = string.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3 - charAt() 테스트")
    @Test
    public void charAtTest() {
        String str = "abc";
        char result1 = str.charAt(0);
        char result2 = str.charAt(1);
        char result3 = str.charAt(2);

        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            str.charAt(100);
        });
    }
}
