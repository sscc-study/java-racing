package org.sscc.study;

import java.util.Vector;
import java.util.stream.Collectors;

public class Register {
    private final Vector<Car> carList = new Vector<>();
    private Vector<String> roundResult = new Vector<>();

    public Register(int carNumber) {
        while (carNumber > 0) {
            carList.add(new Car());
            carNumber--;
        }
    }

    public void executeRound() {
        move();
        ResultView.printRoundResult(roundResult);
    }

    private void move() {
        carList.forEach(Car::moveForward);
        saveStatus();
    }

    private void saveStatus() {
        roundResult = carList.stream()
                .map(Car::getPositionBar)
                .collect(Collectors.toCollection(Vector::new));
    }
}
