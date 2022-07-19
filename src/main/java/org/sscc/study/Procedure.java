package org.sscc.study;

import java.util.stream.IntStream;

public class Procedure {
    private static int rounds;
    private static Register register;

    public static void start() {
        preset();
        execute();
    }

    public static void preset() {
        int carNumber;
        carNumber = InputView.getCarNumber();
        register = new Register(carNumber);

        rounds = InputView.getRound();
    }

    public static void execute() {
        ResultView.printFormat();
        IntStream.range(0, rounds).forEach(rounds -> register.executeRound());
    }
}
