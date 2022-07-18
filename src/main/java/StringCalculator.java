import java.util.Scanner;

public class StringCalculator {
    private final String InitialInput;
    private String[] SplitContents;
    public int result;

    public StringCalculator() {
        Scanner scanner = new Scanner(System.in);
        InitialInput = scanner.nextLine();
        scanner.close();
    }

    public StringCalculator(String InitialInput) {
        this.InitialInput = InitialInput;
    }

    public void splitString() {
        SplitContents = InitialInput.split(" ");
    }

    public void selectOperation() throws IllegalArgumentException {
        result = Integer.parseInt(SplitContents[0]);
        for (int i = 0; i < SplitContents.length - 2; i += 2) {
            String operator = SplitContents[i + 1];
            result = operation(operator, Integer.parseInt(SplitContents[i + 2]));
        }
    }

    public int operation(String operator, int nextNum) {
        switch (operator) {
            case "+":
                return result += nextNum;
            case "-":
                return result -= nextNum;
            case "/":
                return result /= nextNum;
            case "*":
                return result *= nextNum;
            default:
                throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
    }

    public void printResult() {
        System.out.println(result);
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();

        stringCalculator.splitString();
        stringCalculator.selectOperation();
        stringCalculator.printResult();

    }
}
