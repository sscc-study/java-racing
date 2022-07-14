import com.sun.jdi.StringReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @DisplayName("split test")
    @Test
    public void SplitTest(){
        String test1 = "1,2";
        String test2 = "1";

        String[] result1 = test1.split("1");
        String[] result2 = test2.split(",");

        assertThat(result1).contains("1","2");
        assertThat(result2).containsExactly("1");
    }

    @DisplayName("substring test")
    @Test
    public void SubstringTest(){
        String test = "(1,2)";

        String result = test.substring(1,test.length()-1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt test")
    @Test
    public void CharAtTest(){
        String test = "abc";

        char result1 = test.charAt(0);
        char result2 = test.charAt(1);
        char result3 = test.charAt(2);

        assertThat(result1).isEqualTo('a');
        assertThat(result2).isEqualTo('b');
        assertThat(result3).isEqualTo('c');
    }

    @DisplayName("charAt exception test")
    @Test
    public void CharAtException(){
        String test = "abc";

        assertThatThrownBy(()-> {
            test.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
