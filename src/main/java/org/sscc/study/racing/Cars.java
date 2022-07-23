package org.sscc.study.racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    public static RandomStrategy randomStrategy = new Random();

    public Cars(int number) {
        cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car(""));
        }
    }

    public void run() {
        for (Car car : cars) {
            car.move(randomStrategy);
        }
    }

    public List<Car> getResult() {
        return cars;
    }
}
