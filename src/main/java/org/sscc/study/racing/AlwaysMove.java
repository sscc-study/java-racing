package org.sscc.study.racing;

public class AlwaysMove implements MoveStrategy {
    @Override
    public boolean isMoveAble() {
        return true;
    }
}