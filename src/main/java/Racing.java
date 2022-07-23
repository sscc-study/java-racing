import java.util.Random;

public class Racing {
    public void runRace(Car car) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < car.getRacingCount(); ++i) {
            resultView.printRace(car);
            decideStop(car);
        }
    }

    public void decideStop(Car car) {
        for (int j = 0; j < car.getCarCount(); j++) {
            Random random = new Random();
            if (random.nextInt(10) >= 4) {
                car.go(j);
            }
        }
    }
}
