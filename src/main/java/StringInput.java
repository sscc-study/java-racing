import java.util.Scanner;

public class StringInput {
    String initialUserInput;

    StringInput() {
        Scanner scanner = new Scanner(System.in);
        initialUserInput = scanner.nextLine();
        scanner.close();
    }
}
