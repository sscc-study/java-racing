package org.sscc.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringClassTest {
    @Test
    public void split(){
        String[] first = "1,2".split(",");
        String[] second = "1,".split(",");

        assertThat(first).contains("1","2");
        assertThat(second).containsExactly("1");
    }
    @Test
    public void substring(){
        String basic="(1,2)";
        String result=basic.substring(1,basic.length()-1);

        assertThat(result).isEqualTo("1,2");
    }
    @Test
    @DisplayName("abc 문자열이 주어졌을 때 특정 위치의 문자 가져오는 테스트")
    public void charAtTest() {
        String str = "abc";

        char result = str.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("문자 가져올 때 위치 값 벗어나면 Exception 발생")
    public void charAtThrownExceptionTest(){
        String str="abc";

        assertThatThrownBy(() -> str.charAt(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}