package org.sscc.study;

import java.util.Vector;
import java.util.List;
import java.util.stream.Collectors;

public class Round {
    private Roster someExhaustClass;

    public Round(Roster roster) {
        this.someExhaustClass = roster;
    }

    public Roster roundResult() {
        executeRound();
        return new Roster(someExhaustClass);
    }

    private void executeRound() {
        for (Car car : someExhaustClass.roster()) {
            car.moveForward();
        }
    }
}
