package org.sscc.study.racing;

public class RacingGame {
    public static void main(String[] args) {
        InputView input = new InputView();
        input.getValue();
        CarRacing carRacing = new CarRacing(input.getNumber(), input.getCount());
        carRacing.raceStart(new RandomMove());
    }
}