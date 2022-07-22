import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private int car;
    private int racing;
    private String[] cars;

    public InputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        car = scanner.nextInt();
        System.out.println("시도 할 횟수는 몇 회 인가요?");
        racing = scanner.nextInt();

        cars=new String[car];
        Arrays.fill(cars, "-");
    }

    public int getRacing() {
        return racing;
    }

    public int getCar() {
        return car;
    }

    public String[] getCars() {
        return cars;
    }

    public void go(int num){
        cars[num] += "-";
    }

}
