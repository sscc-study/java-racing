import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<RacingCar> cars = new ArrayList<>();
    private final ResultView resultView = new ResultView();

    void readyGame(int carCount){
        for(int i=0; i<carCount; i++){
            cars.add(new RacingCar());
        }
    }

    void startGame(int tryCount){
        for(int i=0; i<tryCount; i++){
            for(RacingCar car : cars){
                int tmpNumber = car.randomNumber();
                car.tryMove(tmpNumber);
                resultView.showCarPosition(car.getSuccessCount());
            }
            System.out.println();
        }
    }


}
