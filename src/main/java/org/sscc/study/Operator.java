package org.sscc.study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (operand1, operand2) -> operand1 + operand2),
    SUBTRACTION("-", (operand1, operand2) -> operand1 - operand2),
    MULTIPLICATION("*", (operand1, operand2) -> operand1 * operand2),
    DIVISION("/", (operand1, operand2) -> {
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

    public static double calculate(double operand1, String operator, double operand2) {
        return matchOperator(operator).expression.apply(operand1, operand2);
    }

    private static Operator matchOperator(String input) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(input))
                .findFirst().orElse(null);
    }
}
