package org.sscc.study.racing;

import java.util.List;

public class CarRacing {
    private final Cars cars;
    private final int count;

    public CarRacing(int number, int count) {
        this.count = count;
        cars = new Cars(number);
    }

    public void raceStart() {
        for (int i = 0; i < count; i++) {
            cars.run();
            ResultView.printCars(cars.getResult());
        }
    }

    public List<Car> getResult() {
        return cars.getResult();
    }
}
