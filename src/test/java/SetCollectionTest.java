import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



import java.util.Set;
import java.util.HashSet;

class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void SetSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void SetContainTest(int number){
        assertThat(numbers).contains(number);
    }

    @Test
    void SetAdditionalContainTest(){
        assertThat(numbers.contains(1)).isEqualTo(true);
        assertThat(numbers.contains(2)).isEqualTo(true);
        assertThat(numbers.contains(3)).isEqualTo(true);

        assertThat(numbers.contains(4)).isEqualTo(false);
        assertThat(numbers.contains(5)).isEqualTo(false);
    }
}
