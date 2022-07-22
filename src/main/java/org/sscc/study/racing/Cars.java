package org.sscc.study.racing;

import java.util.Arrays;
import java.util.Random;

public class Cars {
    private final String[] car;

    public Cars(int number){
        car = new String[number];
        Arrays.fill(car, "");
    }

    public void move(int index){
        if(randomValue())
            car[index]+="-";
    }

    public String[] getResult(){
        return car;
    }

    private boolean randomValue(){
        return (Math.random()*10) >= 4;
    }
}
