import java.util.Scanner;

public class InputView {
    public Car inputCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = scanner.nextInt();
        System.out.println("시도 할 횟수는 몇 회 인가요?");
        int racingCount = scanner.nextInt();

        Car car = new Car(carCount, racingCount);
        return car;
    }
}
