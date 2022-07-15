import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers; //numbers를 Set으로 준다.

    @BeforeEach // 본 어노테이션을 붙인 메서드는 테스트 메서드 실행 이전에 수행된다.
    void setUp() {
        numbers = new HashSet<>(); // HashSet으로 생성
        numbers.add(1); // 1 추가하기
        numbers.add(1); // 1 추가하기
        numbers.add(2); // 2 추가하기
        numbers.add(3); // 3 추가하기
    }

    @Test // 본 어노테이션을 붙이면 Test 메서드로 인식하고 테스트 한다.
    void SetSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest // 다른 인자들로 테스트를 여러번 하는 것이다.
    @ValueSource(ints = { 1, 2, 3 }) // 리터럴 값의 배열에 대한 접근을 제공하는 어노테이션 입니다.
    void SetContainTest(int number){
        assertThat(numbers).contains(number);
    }

    @Test
    void SetAdditionalContainTest(){
        // 실행결과 true 시도
        assertThat(numbers.contains(1)).isEqualTo(true);
        assertThat(numbers.contains(2)).isEqualTo(true);
        assertThat(numbers.contains(3)).isEqualTo(true);

        // 실행결과 false 시도
        assertThat(numbers.contains(4)).isEqualTo(false);
        assertThat(numbers.contains(5)).isEqualTo(false);
    }
}