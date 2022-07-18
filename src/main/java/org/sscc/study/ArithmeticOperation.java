package org.sscc.study;

import java.util.Scanner;

public class ArithmeticOperation {
    static Scanner scanner;
    static String input;
    static String output = "";
    static Calculator calculator;

    public static void main(String[] args) {
        getInput();
        calculate();
        printOutput();
    }

    private static void getInput() {
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
    }

    private static void calculate() {
        try {
            calculator = new Calculator(input);
            output = calculator.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printOutput() {
        System.out.println(output);
    }
}