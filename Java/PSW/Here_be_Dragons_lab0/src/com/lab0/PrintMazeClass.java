package com.lab0;

// Class to print the maze content
public class PrintMazeClass {
    static int mazeSize = 10;
    public static void printMaze(int[][] maze) {
        for (int i = 0; i < mazeSize; i++) {
            for (int k = 0; k < mazeSize; k++) {

                switch (maze[i][k]) {
                    case 1:
                        System.out.print("X ");
                        break;
                    case 2:
                        System.out.print("H ");
                        break;
                    case 3:
                        System.out.print("D ");
                        break;
                    case 4:
                        System.out.print("E ");
                        break;
                    case 5:
                        System.out.print("K ");
                        break;
                    case 0:
                        System.out.print("  ");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid maze char");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
