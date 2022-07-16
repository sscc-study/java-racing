import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("Set size check")
    void checkSize() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @DisplayName("Set exist check (Deduplication)")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void usingContains(int nums) {
        assertTrue(numbers.contains(nums));
    }

    @DisplayName("Set exist check (even contains() false)")
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"},delimiter = ':')
    @ParameterizedTest
    void usingContains_true_false (int nums, boolean expected) {
        assertThat(numbers.contains(nums)).isEqualTo(expected);
    }
}