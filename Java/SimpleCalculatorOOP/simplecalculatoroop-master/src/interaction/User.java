package interaction;

import java.util.Scanner;

public class User {
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer number: ");
        int userInput = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return userInput;
    }
}
