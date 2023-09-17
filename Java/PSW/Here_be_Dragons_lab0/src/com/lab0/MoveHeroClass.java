package com.lab0;

public class MoveHeroClass {
    /* Returns:
        o -> Game Over // Hitted the Dragon
        1 -> In the Game
        2 -> Game Win
    */
    public static int moveHero(int[][] maze, char move) {
        // variable to save pos
        int[] pos;
        int i = 0, k = 0;

        //pos = FindPosClass.findPos(maze,4);
        //System.out.println(pos[0] + " " + pos[1]);
        // Check if the movement is valid


        // Find Hero position
        pos = FindPosClass.findPos(maze, 2);
        i = pos[0];
        k = pos[1];

        switch (move) {
            case 'w':
                // Check if you pick the key
                if (maze[i - 1][k] == 5 && !GlobalVariable.key) GlobalVariable.key = true;

                // Check if you hit the Exit
                if (maze[i - 1][k] != 1 && GlobalVariable.key) {
                    return 2;
                } else {
                    maze[i - 1][k] = 4;
                    maze[i][k] = 2;
                }

                // Check if you hit the wall
                if (maze[i - 1][k] != 1) {
                    maze[i - 1][k] = 2;
                    maze[i][k] = 0;
                }
                return 1;

            case 's':

                // Check if you pick the key
                if (maze[i + 1][k] == 5 && !GlobalVariable.key) GlobalVariable.key = true;

                // Check if you hit the Exit
                if (maze[i + 1][k] != 1 && GlobalVariable.key) {
                    return 2;
                } else {
                    maze[i + 1][k] = 4;
                    maze[i][k] = 2;
                }

                // Check if you hit the wall
                if (maze[i + 1][k] != 1) {
                    maze[i + 1][k] = 2;
                    maze[i][k] = 0;
                }
                return 1;

            case 'a':

                // Check if you pick the key
                if (maze[i][k - 1] == 5 && !GlobalVariable.key) GlobalVariable.key = true;

                // Check if you hit the Exit
                if (maze[i][k - 1] != 1 && GlobalVariable.key) {
                    return 2;
                } else {
                    maze[i][k - 1] = 4;
                    maze[i][k] = 2;
                }

                // Check if you hit the wall
                if (maze[i][k - 1] != 1) {
                    maze[i][k - 1] = 2;
                    maze[i][k] = 0;
                }
                return 1;

            case 'd':

                // Check if you pick the key
                if (maze[i][k + 1] == 5 && !GlobalVariable.key) GlobalVariable.key = true;

                // Check if you hit the Exit
                if (maze[i][k + 1] != 1 && GlobalVariable.key) {
                    return 2;
                } else {
                    maze[i][k + 1] = 4;
                    maze[i][k] = 2;
                }

                // Check if you hit the wall
                if (maze[i][k + 1] != 1) {
                    maze[i][k + 1] = 2;
                    maze[i][k] = 0;
                }
                return 1;

            default:
                System.out.println("Invalid move");
                return 1;
        }
    }
}
