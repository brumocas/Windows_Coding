package com.lab0;

import java.util.Random;

public class RandomNumber {
    static int MAZESIZE = 10;
    public static int randomNumber(){
        Random random = new Random();

        // Generate a random integer between 0 (inclusive) and 9 (inclusive)
        return random.nextInt(MAZESIZE);

    }
}
