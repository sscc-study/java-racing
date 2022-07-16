package org.sscc.study;

import java.util.Scanner;

public class ArithmeticOperation {
    static Scanner scanner;
    static String input;
    static Calculator calculator;

    public static void main(String[] args) {
        setEnv();
        start();
    }

    static void setEnv() {
        scanner = new Scanner(System.in);
        input = scanner.nextLine();
        calculator = new Calculator();
    }

    static void start() {
        try {
            calculator.bootUp(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}