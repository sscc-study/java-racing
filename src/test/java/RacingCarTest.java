import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    private final RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("Racing Car 전진시 successCount 증가 테스트")
    void moveTest(){
        racingCar.tryMove(5);
        assertThat(racingCar.getSuccessCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("0-9 사이의 random 값 발생 테스트")
    void randomRangeTest(){
        assertThat(racingCar.randomNumber()).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}

