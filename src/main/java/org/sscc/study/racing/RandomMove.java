package org.sscc.study.racing;

public class RandomMove implements MoveStrategy {
    @Override
    public boolean isMoveAble() {
        return (Math.random() * 10) >= 4;
    }
}