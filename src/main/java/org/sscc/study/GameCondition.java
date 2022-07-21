package org.sscc.study;

import java.util.Random;

public class GameCondition {
    private final int THRESHOLD = 4;
    private final Random random = new Random();
    private final int RANDOM_BOUND = 10;

    public boolean movable() {
        return randomValue() >= THRESHOLD;
    }

    public int randomValue() {
        return random.nextInt(RANDOM_BOUND);
    }
}
