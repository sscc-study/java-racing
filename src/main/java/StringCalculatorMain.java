public class StringCalculatorMain
{
    public static void main(String[] args) {
        StringInput.Input();
        StringCalculator stringCalculator = new StringCalculator(StringInput.InitialUserInput);

        stringCalculator.splitString();
        stringCalculator.selectOperation();
        System.out.println(stringCalculator.getResult());

    }
}
