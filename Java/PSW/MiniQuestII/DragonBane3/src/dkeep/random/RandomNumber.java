package dkeep.random;

import java.util.Random;

public class RandomNumber {
    public static int randomNumber(){
        Random random = new Random();

        // Generate a random integer between 0 (inclusive) and 9 (inclusive)
        return random.nextInt(10);

    }

    public static int randomMove(){
        // Create a Random object
        Random random = new Random();

        // Generate a random integer between -1 and 1 (inclusive)
        return random.nextInt(3) - 1;
    }
}
