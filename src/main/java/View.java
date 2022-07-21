public class View {
    public static void main(String[] args) {
        int[] input = InputView.getValue();
        CarRacing carRacing = new CarRacing(input[0], input[1]);
        carRacing.run();
    }
}