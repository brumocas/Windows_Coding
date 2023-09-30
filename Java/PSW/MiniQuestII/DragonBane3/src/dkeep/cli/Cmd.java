package dkeep.cli;

import java.util.Scanner;

public class Cmd {
    public static char getCmd() {
        System.out.println("Insert your next move:");

        Scanner scanner = new Scanner(System.in);

        // Close the scanner when you are done with it (usually at the end of your program)
        //scanner.close(); // won't work here because this is being invoked in a while loop

        // Read a single character from the input
        return scanner.next().charAt(0);
    }

}
