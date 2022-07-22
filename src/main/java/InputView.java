import java.util.Scanner;

public class InputView {
    private int carCount;
    private int tryCount;

    public void setUpRacingGame(){
        Scanner s = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        carCount = s.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        tryCount = s.nextInt();
    }

    public int getCarCount(){
        return carCount;
    }

    public int getTryCount(){
        return tryCount;
    }
}
