import java.util.Arrays;
import java.util.Scanner;

public class CarRacing {
    private Cars cars;
    private int count;

    public CarRacing(int number, int count){
        this.count = count;
        cars = new Cars(number);
    }

    // 랜덤을 구하는 함수
    private boolean randomValue(){
        return (Math.random() * 10) >= 4;
    }
    
    // 이동 함수
    private void moveCar(int index){
        if(randomValue()){
            cars.move(index);
        }
    }

    // 실행 함수
    private void run(){
        for(int i=0; i<cars.length(); i++){
            moveCar(i);
        }
    }

    // 경주 시작
    public void start(){
        for(int i=0; i<count; i++){
            run();
            ResultView.printCars(cars.getResult());
        }
    }
}