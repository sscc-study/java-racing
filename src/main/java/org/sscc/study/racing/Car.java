package org.sscc.study.racing;

public class Car {
    private String car;

    public Car(String car) {
        this.car = car;
    }

    public void move(RandomStrategy random) {
        if (random.getValue()) {
            car += "-";
        }
    }

    public String getCar() {
        return car;
    }
}
