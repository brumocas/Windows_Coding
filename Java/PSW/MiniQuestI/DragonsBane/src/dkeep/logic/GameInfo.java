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
public class GameInfo {
    private boolean key = false;
    private final int MazeSize = 10;
    private final int[][] maze = {
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

    public static void setCharacters(GameInfo game){
        RandomPos.hero(game);
        RandomPos.key(game);
        RandomPos.Dragon(game);
    }

    // Create default constructor
    public GameInfo(){

    }

    // Change maze pos (setter)
    public void setElement(int i, int k, int character){
        maze[i][k] = character;
    }

    // Get element (getter)
    public int getElement(int i, int k){
        return maze[i][k];
    }

    // Change key status (setter)
    public void takeKey(){
        key = true;
    }

    // Get key (getter)
    public boolean getkeystatus(){
        return key;
    }

    // Get maze (getter)
    public int[][] getMaze(){
        return maze;
    }

    // Get length (
    public int getLength(){
        return MazeSize;
    }

}
