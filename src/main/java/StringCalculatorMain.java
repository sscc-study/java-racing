public class StringCalculatorMain {
    public static void main(String[] args) {
        StringInput stringInput = new StringInput();
        StringCalculator stringCalculator = new StringCalculator(stringInput.initialUserInput);

        int result = stringCalculator.operation();
        System.out.println(result);
    }
}
