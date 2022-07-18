package org.sscc.study;

import java.text.DecimalFormat;

public class Calculator {
    private final String input;
    private String[] stringArray;
    private double output;
    private String trimmedOutput;

    public Calculator(String input) throws Exception {
        this.input = input;
        checkIfNullOrEmpty();
        setStringArray();
        checkInvalidOperand();
        checkInvalidOperator();
    }

    public String execute() throws Exception {
        calculate();
        trimValue();
        return trimmedOutput;
    }

    private void checkIfNullOrEmpty() throws Exception {
        if (input == null)
            throw new IllegalArgumentException();
        if (input.isEmpty() || input.isBlank())
            throw new IllegalArgumentException();
    }

    private void setStringArray() {
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
        if (hasInvalidOperator(i))
            throw new IllegalArgumentException();
    }

    private boolean hasInvalidOperator(int i) {
        if (i >= stringArray.length)
            return false;
        if (stringArray[i].matches("[+*/-]"))
            return hasInvalidOperator(i + 2);
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

    private double calculate(double operand1, String operator, double operand2) throws Exception {
        return Operator.calculate(operand1, operator, operand2);
    }

    private void trimValue() {
        DecimalFormat df = new DecimalFormat("#.######");
        trimmedOutput = df.format(output);
    }
}
