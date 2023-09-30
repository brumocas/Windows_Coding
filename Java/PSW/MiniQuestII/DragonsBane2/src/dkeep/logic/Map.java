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
        2 -> Hero
        3 -> Dragon
        4 -> Exit
        5 -> Sword
        6 -> Armed Hero

         */
public class Map {
    private static int numberDragons = 0;
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

    // Get element number (getter)
    public int getElement(int i, int k) {
        return maze[i][k];
    }

    // Get maze length
    public int getLength() {
        return 10;
    }

    // Get Wall info
    public static int getWall() {
        return 1;
    }

    // Get Exit info
    public static int getExit() {
        return 4;
    }

    // Get space info
    public static int getSpace() {
        return 0;
    }

    // Set number of dragons to be killed
    public void setNumberDragons(int num){
        numberDragons = num;
    }

    // Kill Dragon
    public void killDragon(){
        numberDragons--;
    }

    // Check if all Dragons are Dead
    public boolean statusDragons(){
        return numberDragons < 1;
    }
}
