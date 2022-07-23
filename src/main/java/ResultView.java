public class ResultView {
    public void printRace(Car car) {
        for (String string : car.getRacingCars()) {
            System.out.println(string);
        }
        System.out.println();
    }
}
