package org.sscc.study;

import java.util.Vector;

public class ResultView {
    public static void printFormat() {
        System.out.println("\n실행결과");
    }

    public static void printRoundResult(Vector<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }
}
