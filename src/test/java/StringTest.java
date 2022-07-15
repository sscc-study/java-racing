import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {

    @DisplayName("split 테스트")
    @Test
    public void splitTest(){
        // given
        String test1 = "1,2";
        String test2 = "1";

        // when
        String[] result1 = test1.split(",");
        String[] result2 = test2.split(",");

        // then
        assertThat(result1).contains("1", "2");
        assertThat(result2).containsExactly("1");
    }

    @DisplayName("substring 테스트")
    @Test
    public void substringTest(){
        // given
        String string = "(1,2)";

        //when
        String result = string.substring(1, string.length()-1);

        //then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 테스트")
    @Test
    public void charAtTest(){
        // given
        String test = "abc";
        // then
        assertThat(test.charAt(0)).isEqualTo('a');
        assertThat(test.charAt(1)).isEqualTo('b');
        assertThat(test.charAt(2)).isEqualTo('c');
    }

    @DisplayName("예외 테스트")
    @Test
    public void exceptionTest(){
        // given
        String test = "abc";
        // then
        assertThatThrownBy(()->{
            test.charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}