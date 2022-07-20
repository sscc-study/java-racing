import java.util.Arrays;

public class Cars {
    private String[] car;

    public Cars(int number){
        car = new String[number];
        Arrays.fill(car, "");
    }

    public void move(int index){
        car[index]+="-";
    }

    public int length(){
        return car.length;
    }

    public String getResult(){
        String result = "";
        for(String car : car){
            result = result + car + "\n";
        }
        return result;
    }
}
