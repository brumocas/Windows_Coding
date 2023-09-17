package com.lab0;

import java.util.Scanner;

public class Main {

    public static boolean key = false;

    public static void main(String[] args) {
        // Maze positions
        /*
          -> Empty Cell
        X -> Wall
        H -> Hero
        D -> Dragon
        E -> Exit
        K -> Key

        0 -> empty cell
        1 -> wall
        s
        2 -> Hero
        3 -> Dragon
        4 -> Exit
        5 -> Key
         */
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 3, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 0, 4},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 5, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };

        System.out.println("Here Be Dragons Game\n" + GlobalVariable.key);
        PrintMazeClass.printMaze(maze);

        Scanner scanner = new Scanner(System.in);
        char movement;


        do {

            System.out.println("Insert your next move:");

            // Read a single character from the input
            movement = scanner.next().charAt(0);

            MoveHeroClass.moveHero(maze, movement);

            PrintMazeClass.printMaze(maze);
        }
        while (movement != 'q' && movement != 'Q');

        System.out.println("Game Ended");
        // Close the scanner when you are done with it (usually at the end of your program)
        // scanner.close();

    }
}
