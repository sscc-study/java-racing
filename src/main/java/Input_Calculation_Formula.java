
import java.util.Scanner;

public class Input_Calculation_Formula {
    static Scanner scanner;
    static String input;
    static Calculator calculator;

    public static void main(String[] args) {
        enter_Result();
        bring_Result_And_Print();
    }

    // 계산식을 직접 입력
    static void enter_Result() {
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
        calculator = new Calculator();
    }

    // 계산 결과를 출력
    static void bring_Result_And_Print() {
        try {
            calculator.print(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


