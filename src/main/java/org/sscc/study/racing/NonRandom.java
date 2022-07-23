package org.sscc.study.racing;

public class NonRandom implements RandomStrategy {
    @Override
    public boolean getValue() {
        return true;
    }
}