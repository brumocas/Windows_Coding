package dkeep.logic;

import java.util.List;

public class Map {
    private final int length = 10;
    private int aliveDragons = 0;
    private char[][] maze = {
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
            {'x', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', ' ', 'x', 'x', ' ', 'x', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', 'x', ' ', 'x', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', 'x', ' ', 'x', ' ', 'x', ' ', 'x'},
            {'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', ' ', 'E'},
            {'x', ' ', 'x', 'x', ' ', 'x', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', 'x', ' ', 'x', ' ', 'x', ' ', 'x'},
            {'x', ' ', 'x', 'x', ' ', ' ', ' ', ' ', ' ', 'x'},
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
    };

    // Constructor
    public Map() {
    }

    // Set number of Dragons
    public void setAliveDragons(int number){
        this.aliveDragons = number;
    }

    // Get number of alive Dragons
    public int getAliveDragons(){
        return this.aliveDragons ;
    }

    // Kill dragon
    public void killDragon(Dragon dragon){
        dragon.Kill();
        this.aliveDragons = getAliveDragons() - 1;
    }

    // Setter
    public void set(int x, int y, char ch){
        maze[x][y] = ch;
    }

    // Getter
    public char get(int x, int y){
        return maze[x][y];
    }

    // Get map length
    public int length() {
        return this.length;
    }

    // Print the maze
    public void print() {
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                System.out.print(maze[i][k]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public void overLap(Sword sword, List<Dragon> army){

    }
}
