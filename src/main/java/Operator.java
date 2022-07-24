import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBTRACK("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0){
            throw new ArithmeticException("0���� ���� �� �����ϴ�.");
        }
        return num1 / num2;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;


    Operator(String operator, BiFunction<Integer, Integer, Integer> expression){
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator getOperator(String operator){
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("�����ڸ� �߸� �Է��߽��ϴ�."));
    }

    public static int calculate(String operator, int num1, int num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }
}

