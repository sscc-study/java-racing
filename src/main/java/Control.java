public class Control {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.setUpRacingGame();

        RacingGame racingGame = new RacingGame();
        racingGame.readyGame(inputView.getCarCount());
        racingGame.startGame(inputView.getTryCount());
    }
}
