
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class StringclassTest {
    Stringclass stringclass = new Stringclass();
    @Test
    void splitTest(){
        assertThat(stringclass.splitNum1_2).containsExactly("1","2")
                .contains("1")
                .contains("2");

        assertThat(stringclass.splitNum1).containsExactly("1")
                .contains("1");
    }

    @Test
    void subStringTest(){
        assertThat(stringclass.subString1_2).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드 테스트")
    void charAtTest(){
        assertThat(stringclass.alphabets.charAt((0))).isEqualTo('a');
        assertThat(stringclass.alphabets.charAt((1))).isEqualTo('b');
        assertThat(stringclass.alphabets.charAt((2))).isEqualTo('c');


    }

    @Test
    @DisplayName("charAt() StringIndexOutOfBoundsException 테스트")
    void charAtExceptionTest(){
        Assertions.assertThrows(StringIndexOutOfBoundsException.class, ()->{
            System.out.println(stringclass.alphabets.charAt(4));
        }, "예외가 발생하지 않았습니다.");
    }
}
