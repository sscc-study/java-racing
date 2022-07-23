public class Controller {
    public static void main(String[] args) {
        InputView input = new InputView();
        Car car = input.inputCar();
        Racing race = new Racing();
        race.runRace(car);
    }
}
