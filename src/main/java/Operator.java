import java.util.function.BiFunction;

public enum Operator{
    ADD("+", (operand1, operand2) -> operand1+operand2),
    SUB("-", (operand1, operand2) -> operand1-operand2),
    MUL("*", (operand1, operand2) -> operand1*operand2),
    DIV("/", (operand1, operand2) -> operand1/operand2);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression){
        this.symbol = symbol;
        this.expression = expression;
    }

    public static int calculate(int operand1, int operand2, String inputSymbol){
        for(Operator operator : Operator.values()) {
            if(operator.match(inputSymbol)){
                return operator.expression.apply(operand1, operand2);
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean match(String inputSymbol) {
        return this.symbol.equals(inputSymbol);
    }
}
