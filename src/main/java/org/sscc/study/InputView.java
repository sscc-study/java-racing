package org.sscc.study;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    private final String MESSAGE_CARS_COUNT = "자동차 대수는 몇 대 인가요?";
    private final String MESSAGE_ROUNDS_COUNT = "시도할 회수는 몇 회 인가요?";
    private Scanner scanner;
    private Integer carsCount;
    private Integer roundsCount;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer carCount() {
        System.out.println(MESSAGE_CARS_COUNT);
        putCarsCount();
        return carsCount;
    }

    public Integer roundCount() {
        System.out.println(MESSAGE_ROUNDS_COUNT);
        putRoundsCount();
        return roundsCount;
    }

    private void putCarsCount() {
        int input = scanner.nextInt();
        if (valid(input)) {
            carsCount = input;
        }
    }

    private void putRoundsCount() {
        int input = scanner.nextInt();
        if (valid(input)) {
            roundsCount = input;
        }
    }

    private boolean valid(int number) {
        return number > 0;
    }
}
