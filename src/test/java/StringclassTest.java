
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class StringclassTest {
    String[] splitNum1_2 = "1,2".split(",");
    String[] splitNum1 = "1".split(",");
    String subString1_2 = "(1,2)".substring(1,4);
    String alphabets = "abc";

    @Test
    void splitTest(){
        assertThat(splitNum1_2).containsExactly("1","2")
                .contains("1")
                .contains("2");

        assertThat(splitNum1).containsExactly("1")
                .contains("1");
    }

    @Test
    void subStringTest(){
        assertThat(subString1_2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 테스트")
    void charAtTest(){
        assertThat(alphabets.charAt((0))).isEqualTo('a');
        assertThat(alphabets.charAt((1))).isEqualTo('b');
        assertThat(alphabets.charAt((2))).isEqualTo('c');


    }

    @Test
    @DisplayName("charAt() StringIndexOutOfBoundsException 테스트")
    void charAtExceptionTest(){
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, ()->{
            System.out.println(alphabets.charAt(4));
        }, "예외가 발생하지 않았습니다.");
    }
}
