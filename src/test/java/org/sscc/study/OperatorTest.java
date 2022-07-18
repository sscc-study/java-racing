package org.sscc.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.withPrecision;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    @ParameterizedTest
    @CsvSource({
            "+, ADD",
            "-, SUBTRACT",
            "*, MULTIPLY",
            "/, DIVIDE"
    })
    @DisplayName("연산자 탐색 테스트")
    void should_findOperator(String input, Operator operator) {
        assertThat(Operator.findOperator(input)).isEqualTo(operator);
    }

    @ParameterizedTest
    @CsvSource({
            "ADD, 3, 5, 8",
            "ADD, 3.23, 5.49, 8.72",
            "SUBTRACT, 3, 5, -2",
            "SUBTRACT, 3.23, 5.49, -2.26",
            "MULTIPLY, 3, 5, 15",
            "MULTIPLY, 3.23, 5.49, 17.7327",
            "DIVIDE, 3, 5, 0",
            "DIVIDE, 3.23, 5.49, 0",
    })
    @DisplayName("사칙 연산 결과 테스트")
    void should_Calculate(Operator symbol, double operand1, double operand2, double result) {
        assertThat(symbol.calculate(operand1, operand2))
                .isEqualTo(result, withPrecision(0.000000_1d));
    }
}