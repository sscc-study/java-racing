import java.util.Random;

public class RacingCar {
    private int successCount;
    private final Random random = new Random();

    public int getSuccessCount(){
        return successCount;
    }

    public void tryMove(int tmpNumber){
        if(canMove(tmpNumber)){
            successCount++;
        }
    }

    public int randomNumber(){
        return random.nextInt(10);
    }

    private boolean canMove(int tmpNumber){
        return (tmpNumber >= 4);
    }
}
