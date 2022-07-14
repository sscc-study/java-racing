import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    public void splitTest(){
        // given
        String test1_1 = "1,2";
        String test1_2 = "1";

        // when
        String[] result1_1 = test1_1.split(",");
        String[] result1_2 = test1_2.split(",");

        // then
        // <contains> : 포함하는지 체크
        // <containsExactly> 그것만 포함하는지 체크
        assertThat(result1_1).contains("1", "2");
        assertThat(result1_2).containsExactly("1");
    }

    @Test
    public void substringTest(){
        // given
        String test2 = "(1,2)";

        //when
        String result2 = test2.substring(1, test2.length()-1);

        //then
        assertThat(result2).isEqualTo("1,2");
    }

    @DisplayName("charAt 작동 테스트")
    @Test
    public void charAtTest(){
        // given
        String test3_1 = "abc";
        // then
        assertThat(test3_1.charAt(0)).isEqualTo('a');
        assertThat(test3_1.charAt(1)).isEqualTo('b');
        assertThat(test3_1.charAt(2)).isEqualTo('c');
    }

    @DisplayName("Exception 테스트")
    @Test
    public void ExceptionTest(){
        // given
        String test3_2 = "abc";
        // then
        assertThatThrownBy(()->{
            test3_2.charAt(10);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}