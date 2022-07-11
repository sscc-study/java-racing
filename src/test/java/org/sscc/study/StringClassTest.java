package org.sscc.study;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class StringClassTest {
    @Test
    void testSplit() {
        //given
        String string1 = "1,2";
        String string2 = "1";

        //when
        String[] stringArray1 = string1.split(",");
        String[] stringArray2 = string2.split(",");

        //then
        assertThat(stringArray1)
                .contains("1", "2")
                .containsExactly("1", "2");
        assertThat(stringArray2)
                .contains("1")
                .containsExactly("1");
    }

    @Test
    void testSubString() {
        //given
        String string = "(1,2)";

        //when
        String subString = string.substring(1, 4);

        //then
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("Test case : 특정 위치의 문자 가져오기")
    void testCharAt() {
        //given
        String string = "abc";
        int index = 2;

        //when
        char ch = string.charAt(index);

        //then
        assertThat(ch).isEqualTo('c');
    }

    @Test
    @DisplayName("Test case : StringIndexOutOfBoundsException")
    void testCharAtIndexOutOfBounds() {
        //given
        String string = "abc";
        int index = 10;

        //when
        Throwable thrown = catchThrowable(() -> {
            char ch = string.charAt(index);
        });

        //then
        assertThat(thrown)
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}