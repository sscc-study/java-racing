package org.sscc.study;

import java.util.Random;
import java.util.stream.IntStream;

public class Car {
    private GameCondition gameCondition;
    private int position;

    public Car(Car car) {
        this(new GameCondition(), car.currentPosition());
    }
    public Car() {
        this(new GameCondition());
    }

    public Car(GameCondition gameCondition) {
        this(gameCondition, 0);
    }

    public Car(GameCondition gameCondition, int position) {
        this.gameCondition = gameCondition;
        this.position = position;
    }

    public void moveForward() {
        if (gameCondition.movable()) {
            position++;
        }
    }

    public int currentPosition() {
        return this.position;
    }
}
