package org.sscc.study.racing;

public class CarRacing {
    private final Cars cars;
    private final int count;

    public CarRacing(int number, int count) {
        this.count = count;
        cars = new Cars(number);
    }

    public void raceStart(MoveStrategy moveStrategy) {
        for (int i = 0; i < count; i++) {
            cars.run(moveStrategy);
            ResultView.printCars(cars.toString());
        }
    }

    public String getResult() {
        return cars.toString();
    }
}
