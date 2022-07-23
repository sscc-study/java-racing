import java.util.Arrays;

public class Car {
    private final int carCount;
    private final int racingCount;
    private final String[] racingCars;

    Car(int carCount, int racingCount) {
        this.carCount = carCount;
        this.racingCount = racingCount;
        racingCars = new String[carCount];
        Arrays.fill(racingCars, "-");
    }

    public int getRacingCount() {
        return racingCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public String[] getRacingCars() {
        return racingCars;
    }

    public void go(int num) {
        racingCars[num] += "-";
    }
}
