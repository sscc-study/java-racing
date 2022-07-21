package org.sscc.study;

import java.util.List;
import java.util.Vector;
import java.util.stream.IntStream;

public class ResultView {
    private final List<Roster> gameResult;

    public ResultView(List<Roster> gameResult) {
        this.gameResult = gameResult;
    }

    public static void printFormat() {
        System.out.println("\n실행결과");
    }

    public static void printRoundResult(Vector<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    public void printResult() {
        format();
        for (Roster status : gameResult) {
            printDashedRoster(status);
            System.out.println();
        }
    }

    private void format() {
        System.out.println("\n실행결과");
    }

    private void printDashedRoster(Roster status) {
        for (Car car : status.roster()) {
            printDashedPosition(car);
        }
    }

    private void printDashedPosition(Car car) {
        System.out.println(dashPosition(car));
    }

    private String dashPosition(Car car) {
        StringBuffer positionBar = new StringBuffer();
        IntStream.range(0, car.currentPosition()).forEach(move -> positionBar.append("-"));

        return positionBar.toString();
    }
}
