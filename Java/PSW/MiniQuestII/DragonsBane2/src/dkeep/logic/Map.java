package dkeep.logic;

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
public class Map {
    private boolean gameOver = false;
    private static int wall = 1;
    private static int exit = 4;
    private static int space = 0;
    private final int MazeSize = 10;
    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 4},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };


    // Create default constructor
    public Map() {

    }

    // Change maze pos (setter)
    public void setElement(int i, int k, int character) {
        maze[i][k] = character;
    }

    // Get element (getter)
    public int getElement(int i, int k) {
        return maze[i][k];
    }

    // Get maze length
    public int getLength() {
        return MazeSize;
    }

    // Get Wall info
    public static int getWall() {
        return wall;
    }

    // Get Exit info
    public static int getExit() {
        return exit;
    }

    // Get space info
    public static int getSpace() {
        return space;
    }


}
