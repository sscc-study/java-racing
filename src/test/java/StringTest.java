import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class StringTest {
    @Test
    @DisplayName("split test")
    void splitTest() {
        //given
        String str1 = "1,2";
        String str2 = "1";

        //when
        String[] strArray1 = str1.split(",");
        String[] strArray2 = str2.split(",");

        //then
        assertThat(strArray1).contains("1", "2").containsExactly("1", "2");
        assertThat(strArray2).contains("1").containsExactly("1");
    }

    @Test
    @DisplayName("() remove")
    void substring() {
        //given
        String str = "(1,2)";

        //when
        String strSubString = str.substring(1, 4);

        //then
        assertThat(strSubString).isEqualTo("1,2");
    }


    @Test
    @DisplayName("charAt test")
    void charAt() {
        //given
        String str = "abc";
        int index = 1;

        //when
        char ch = str.charAt(index);

        //then
        assertThat(ch).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt Exception")
    void charAtException() {
        //given
        String str = "abc";
        int index = 56;

        //when
        Throwable thrown = catchThrowable(() -> {
            char ch = str.charAt(index);
        });

        //then
        assertThat(thrown).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("%d", index);
    }
}