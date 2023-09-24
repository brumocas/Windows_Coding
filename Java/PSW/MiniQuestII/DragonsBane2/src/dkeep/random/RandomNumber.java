package dkeep.random;

import java.util.Random;

public class RandomNumber {
    public static int randomNumber(){
        Random random = new Random();

        // Generate a random integer between 0 (inclusive) and 9 (inclusive)
        return random.nextInt(10);

    }
}
