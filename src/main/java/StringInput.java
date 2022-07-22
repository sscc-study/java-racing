import java.util.Scanner;

public class StringInput {
    static String InitialUserInput;

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        InitialUserInput = scanner.nextLine();
        scanner.close();
    }
}
