package com.lab0;

// Class to find the provided character position
public class FindPosClass {
    static int mazeSize = 10;
    public static int[] findPos(int[][] maze, int character) {
        int[] pos = new int[2];
        for (int i = 0; i < mazeSize; i++) {
            for (int k = 0; k < mazeSize; k++) {
                if (maze[i][k] == character) {
                    pos[0] = i;
                    pos[1] = k;
                    return pos;
                }
            }
        }
        throw new IllegalArgumentException("Character not found");
    }
}
