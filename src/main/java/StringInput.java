import java.util.Scanner;

public class StringInput {
    static String initialUserInput;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        initialUserInput = scanner.nextLine();
        scanner.close();
    }
}
