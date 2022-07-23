package org.sscc.study.racing;

import java.util.List;

public class ResultView {
    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCar());
        }
        System.out.println();
    }
}