import java.util.Scanner;

public class InputView {
    public static int[] getValue(){
        Scanner sc = new Scanner(System.in);
        int[] result = new int[2];
        System.out.println("자동차 대수는 몇 대 인가요?");
        result[0] = sc.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        result[1] = sc.nextInt();
        return result;
    }
}