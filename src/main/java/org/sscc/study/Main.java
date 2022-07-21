package org.sscc.study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView(new Scanner(System.in));

            RacingGame racingGame = new RacingGame(inputView.carCount(), inputView.roundCount());

            ResultView resultView = new ResultView(racingGame.gameResult());
            resultView.printResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
