
public class StringCalculator {
    private final String[] splitContents;
    private int result;

    public StringCalculator(String initialInput) {
        splitContents = initialInput.split(" ");
    }

    public int getResult() {
        return result;
    }

    public int operation() throws IllegalArgumentException {
        result = Integer.parseInt(splitContents[0]);
        for (int i = 0; i < splitContents.length - 2; i += 2) {
            String symbol = splitContents[i + 1];
            Operator operator = Operator.findOperator(symbol);
            result = operator.operate(result, Integer.parseInt(splitContents[i + 2]));
        }
        return result;
    }
}
