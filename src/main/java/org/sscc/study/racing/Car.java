package org.sscc.study.racing;

public class Car {
    private String car;

    public Car(String car){
        this.car = car;
    }

    public void move(){
        if(randomValue())
            car+="-";
    }

    private boolean randomValue(){
        return (Math.random()*10) >= 4;
    }

    public String getCar() {
        return car;
    }
}
