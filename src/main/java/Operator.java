import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (num1, num2)-> num1+num2),
    SUBTRACTION("-", (num1, num2)-> num1-num2),
    DIVISION("/", (num1, num2)-> num1/num2),
    MULTIPLICATION("*", (num1, num2)-> num1*num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> calculateExpressions;

    Operator(String operator, BiFunction<Integer, Integer, Integer> calculateExpressions) {
        this.operator = operator;
        this.calculateExpressions = calculateExpressions;
    }

    public static int checkOperation(Integer num1, Integer num2, String operator){
        Operator result = Arrays.stream(Operator.values())
                .filter(value -> value.operator.equals(operator))
                .findAny()
                .orElse(null);
        if(result==null){
            throw new IllegalArgumentException("올바르지 않은 사칙연산기호입니다.");
        }
        return result.calculateExpressions.apply(num1, num2);
    }
}
