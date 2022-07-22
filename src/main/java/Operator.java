import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    //생성자 인자
    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    //생성자
    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Integer operate(Integer x, Integer y) {
        return this.operation.apply(x, y);
    }

    public static Operator findOperater(String symbol) {
        for (Operator operator : Operator.values()) {
            if (symbol.equals(operator.symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
    }
}
