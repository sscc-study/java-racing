package org.sscc.study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (operand1, operand2) -> operand1 + operand2),
    SUBTRACT("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", (operand1, operand2) -> {
        if (operand2 == 0.0)
            throw new ArithmeticException();
        return (double) (int) (operand1 / operand2);
    });

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public double calculate(double operand1, double operand2) {
        return expression.apply(operand1, operand2);
    }

    public static Operator findOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(input))
                .findFirst().orElse(null);
    }
}
