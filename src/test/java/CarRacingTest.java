import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @Test
    @DisplayName("전진 횟수가 주어진 값 사이로 들어오는 지 확인")
    public void test() {
        CarRacing carRacing = new CarRacing(4, 10);
        carRacing.run();
        String[] result = carRacing.getResult();
        for (String car : result) {
            assertThat(car.length()).isGreaterThanOrEqualTo(0)
                    .isLessThanOrEqualTo(10);
        }
    }
}