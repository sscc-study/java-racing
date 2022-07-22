
public class StringCalculator {
    private final String InitialInput;
    private String[] SplitContents;
    private int result;

    public StringCalculator(String InitialInput) {
        this.InitialInput = InitialInput;
    }

    public int getResult() {
        return result;
    }

    public void splitString() {
        SplitContents = InitialInput.split(" ");
    }

    public int operation() throws IllegalArgumentException {
        result = Integer.parseInt(SplitContents[0]);
        for (int i = 0; i < SplitContents.length - 2; i += 2) {
            String symbol = SplitContents[i + 1];
            Operator operator = Operator.findOperater(symbol);
            result = operator.operate(result, Integer.parseInt(SplitContents[i + 2]));
        }
        return result;
    }
}
