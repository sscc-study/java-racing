package org.sscc.study;

import java.util.List;
import java.util.Vector;

public class Roster {
    private List<Car> roster = new Vector<>();
    private final Integer carCount;

    public Roster(Roster that) {
        this.carCount = that.rosterSize();
        this.roster = new Vector<>(that.roster().size());
        for (Car car : that.roster()) {
            roster.add(new Car(car));
        }
    }

    public Roster(Integer carCount) {
        this.carCount = carCount;
        put();
    }

    private void put() {
        for (int i = 0; i < carCount; i++) {
            roster.add(new Car());
        }
    }

    public int rosterSize() {
        return carCount;
    }

    public List<Car> roster() {
        return roster;
    }
}
