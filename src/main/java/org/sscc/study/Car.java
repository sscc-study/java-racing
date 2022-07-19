package org.sscc.study;

import java.util.Random;
import java.util.stream.IntStream;

public class Car {
    private static final int THRESHOLD = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public void moveForward() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        Random random = new Random();
        return random.nextInt(10) >= THRESHOLD;
    }

    public String getPositionBar() {
        StringBuffer positionBar = new StringBuffer();
        IntStream.range(0, position).forEach(move -> positionBar.append("-"));
        return positionBar.toString();
    }
}
