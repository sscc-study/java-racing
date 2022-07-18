package org.sscc.study;

import java.text.DecimalFormat;

public class Calculator {
    private String[] stringArray;
    private double output;
    private String trimmedOutput;

    public Calculator(String input) throws Exception {
        validationCheck(input);
    }

    public String execute() throws Exception {
        calculate();
        trimValue();
        return trimmedOutput;
    }

    private void validationCheck(String input) throws Exception {
        checkIfNullOrEmpty(input);
        checkInvalidOperand();
        checkInvalidOperator();
    }

    private void checkIfNullOrEmpty(String input) throws Exception {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        setStringArray(input);
    }

    private void setStringArray(String input) {
        stringArray = input.split(" ");
    }

    private void calculate() throws Exception {
        output = Double.parseDouble(stringArray[0]);
        for (int i = 0; i < stringArray.length - 1; i += 2) {
            output = calculate(output, stringArray[i + 1],
                    Double.parseDouble(stringArray[i + 2]));
        }
    }

    private void checkInvalidOperator() throws Exception {
        int i = 1;
        if (hasInvalidOperator(i)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasInvalidOperator(int i) {
        if (i >= stringArray.length) {
            return false;
        }
        if (stringArray[i].matches("[+*/-]")) {
            return hasInvalidOperator(i + 2);
        }
        return true;
    }

    private void checkInvalidOperand() throws Exception {
        for (int i = 0; i < stringArray.length; i += 2) {
            convertException(i);
        }
        for (int i = stringArray.length - 1; i >= 0; i -= 2) {
            convertException(i);
        }
    }

    private void convertException(int i) throws Exception {
        try {
            Double.parseDouble(stringArray[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private double calculate(double operand1, String symbol, double operand2) throws Exception {
        Operator op = Operator.findOperator(symbol);
        return op.calculate(operand1, operand2);
    }

    private void trimValue() {
        DecimalFormat df = new DecimalFormat("#.######");
        trimmedOutput = df.format(output);
    }
}
