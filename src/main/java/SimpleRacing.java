import java.util.Random;

public class SimpleRacing {
    public void runRace(InputView input) {
        printRace(input);
        for (int i = 0; i < input.getRacing() - 1; i++) {
            decideStop(input);
            printRace(input);
        }
    }

    public void decideStop(InputView input) {
        for (int j = 0; j < input.getCar(); j++) {
            Random random = new Random();
            if (random.nextInt(10) >= 4) {
                input.go(j);
            }
        }
    }

    public void printRace(InputView input) {
        for (String car : input.getCars()) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InputView input = new InputView();
        SimpleRacing race = new SimpleRacing();
        race.runRace(input);
    }
}
