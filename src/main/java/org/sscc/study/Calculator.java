package org.sscc.study;

import java.text.DecimalFormat;

public class Calculator {
    String[] stringArray;
    double output;
    String trimmedOutput;

    void bootUp(String input) throws Exception {
        checkIfNullOrEmpty(input);
        setStringArray(input);
        calculate(stringArray);
        print();
    }

    void checkIfNullOrEmpty(String input) throws Exception {
        if (input == null || input == "")
            throw new IllegalArgumentException();
    }

    void setStringArray(String input) {
        stringArray = input.split(" ");
    }

    void calculate(String[] stringArray) throws Exception {
        checkInvalidOperand();
        checkInvalidOperator();

        output = Double.parseDouble(stringArray[0]);
        for (int i = 0; i < stringArray.length - 1; i += 2) {
            output = calculate(output, stringArray[i + 1],
                    Double.parseDouble(stringArray[i + 2]));
        }
    }

    void checkInvalidOperator() throws Exception {
        int i = 1;
        if (hasInvalidOperator(i))
            throw new IllegalArgumentException();
    }

    boolean hasInvalidOperator(int i) {
        if (i >= stringArray.length)
            return false;
        if (stringArray[i].matches("[+*/-]"))
            return hasInvalidOperator(i + 2);
        return true;
    }

    void checkInvalidOperand() throws Exception {
        for (int i = 0; i < stringArray.length; i += 2) {
            convertException(i);
        }
        for (int i = stringArray.length - 1; i >= 0; i -= 2) {
            convertException(i);
        }
    }

    void convertException(int i) throws Exception {
        try {
            Double.parseDouble(stringArray[i]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    double calculate(double operand1, String operator, double operand2) throws Exception {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return (int) divide(operand1, operand2);
            default:
                throw new IllegalArgumentException();
        }
    }

    double divide(double a, double b) throws Exception {
        if (b == 0.0)
            throw new ArithmeticException();
        return a / b;
    }

    void print() {
        trimValue();
        System.out.println(trimmedOutput);
    }

    void trimValue() {
        DecimalFormat df = new DecimalFormat("#.######");
        trimmedOutput = df.format(output);
    }
}
