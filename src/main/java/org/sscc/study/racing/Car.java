package org.sscc.study.racing;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        name+="-";
    }

    public String getName() {
        return name;
    }
}
