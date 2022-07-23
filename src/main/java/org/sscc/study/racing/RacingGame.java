package org.sscc.study.racing;

public class RacingGame {
    public static void main(String[] args) {
        InputView.getValue();
        CarRacing carRacing = new CarRacing(InputView.getNumber(), InputView.getCount());
        carRacing.raceStart();
    }
}