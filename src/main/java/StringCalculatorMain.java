public class StringCalculatorMain {
    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator(StringInput.InitialUserInput);

        stringCalculator.splitString();
        stringCalculator.operation();
        stringCalculator.Output();

    }
}
