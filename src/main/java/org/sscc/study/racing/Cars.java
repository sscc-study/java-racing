package org.sscc.study.racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int number) {
        cars = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cars.add(new Car(""));
        }
    }

    public void run(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            moveCar(car, moveStrategy);
        }
    }

    private void moveCar(Car car, MoveStrategy moveStrategy){
        if(moveStrategy.isMoveAble()){
            car.move();
        }
    }

    @Override
    public String toString() {
        StringBuilder result= new StringBuilder();
        for(Car car : cars){
            result.append(car.getName()).append("\n");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}
