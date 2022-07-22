package org.sscc.study.racing;

public class CarRacing {
    private final Cars cars;
    private final int count;
    private final int number;

    public CarRacing(int number, int count) {
        this.count = count;
        this.number = number;
        cars = new Cars(number);
    }

    private void start() {
        for (int i = 0; i < number; i++) {
            cars.move(i);
        }
    }

    public void run() {
        for (int i = 0; i < count; i++) {
            start();
            ResultView.printCars(cars.getResult());
        }
    }

    public String[] getResult() {
        return cars.getResult();
    }
}