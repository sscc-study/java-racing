package org.sscc.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

class StringClassTest {
    @Test
    @DisplayName("should_SplitString_ForSimpleString")
    void should_SplitString_ForSimpleString() {
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
    @DisplayName("should_ReturnSubstring_ForSimpleString")
    void should_ReturnSubstring_ForSimpleString() {
        //given
        String string = "(1,2)";

        //when
        String subString = string.substring(1, 4);

        //then
        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("should_ReturnCharAtIndex")
    void should_ReturnCharAtIndex() {
        //given
        String string = "abc";
        int index = 2;

        //when
        char ch = string.charAt(index);

        //then
        assertThat(ch).isEqualTo('c');
    }

    @Test
    @DisplayName("should_ThrowException_When_IndexOutOfBounds")
    void should_ThrowException_When_IndexOutOfBounds() {
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