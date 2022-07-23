package org.sscc.study.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;

    public Cars(int number){
        cars = new ArrayList<>();
        for(int i=0; i<number; i++){
            cars.add(new Car(""));
        }
    }

    public void run(){
        for(Car car:cars){
            car.move();
        }
    }

    public List<Car> getResult(){
        return cars;
    }
}
