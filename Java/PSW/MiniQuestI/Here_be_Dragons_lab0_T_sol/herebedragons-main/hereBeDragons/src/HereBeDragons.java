import java.util.Scanner;

public class HereBeDragons {


    static char[][] maze = {{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
            {'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', 'D', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', 'E'},
            {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X'},
            {'X', 'K', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X'},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}};

    static boolean hero_has_key = false;
    static boolean is_game_over = false;

    public static void main(String[] args) throws Exception {
        // Store the maze


        Scanner s = new Scanner(System.in);
        int hx = 1;
        int hy = 1;
        Coordinates hero_coordinates = new Coordinates(hx, hy);


        char pressed_key;

        do {
            print_maze(maze);

            // - read user command
            System.out.print("cmd> ");
            pressed_key = s.next().charAt(0);    // ignore the other characters


            switch (pressed_key) {
                case 'd':// Right
                    move_from_to_cell(hero_coordinates, hero_coordinates.hx, hero_coordinates.hy + 1);
                    break;
                case 's': // Down
                    move_from_to_cell(hero_coordinates, hero_coordinates.hx + 1, hero_coordinates.hy);
                    break;
                case 'a': // Left
                    move_from_to_cell(hero_coordinates, hero_coordinates.hx, hero_coordinates.hy - 1);
                    break;
                case 'w': // Up
                    move_from_to_cell(hero_coordinates, hero_coordinates.hx - 1, hero_coordinates.hy);
                    break;

            }
        }
        while (!is_game_over);


    }


    private static void print_maze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static boolean is_cell_inside_map(int x, int y) {
        if (x < 0 && y < 0 && x >= maze.length && y >= maze.length) {
            System.out.println("Outside Maze Boundaries!");
            return false;
        } else {
            return true;
        }
    }


    // Will return true if the dragon is found near (x,y)
    private static boolean check_for_dragon(int x, int y) {
        // returns true if there is a dragon!
        if (!is_cell_inside_map(x, y)) {
            System.out.println("WARNING! Trying to access invalid zones (" + x + ", " + y + ")");
            return false;
        }

        // to avoid access to non-existent memory places!
        if (is_cell_inside_map(x + 1, y)) {
            if (maze[x + 1][y] == 'D') {
                return true;
            }
        }

        if (is_cell_inside_map(x, y + 1)) {

            if (maze[x][y + 1] == 'D') {
                return true;
            }
        }

        if (is_cell_inside_map(x - 1, y)) {

            if (maze[x - 1][y] == 'D') {
                return true;
            }
        }
        if (is_cell_inside_map(x, y - 1)) {

            if (maze[x][y - 1] == 'D') {
                return true;
            }
        }

        if (maze[x][y] == 'D') {
            System.out.println("You should not be able to be here!");
            return true;
        }

        return false;
    }


    // returns: -1 for error;
//           0 for dragon;
//           1 for free cell
//           2 for Exit cell
//           3 for the Key
//           4 found an X;
    private static int is_cell_free(int x, int y) {


        if (!is_cell_inside_map(x, y)) {
            return -1;
        }

        if (maze[x][y] == ' ' && !check_for_dragon(x, y)) {
            // cell is free. Proceed!
            return 1;
        } else if (maze[x][y] == ' ') {
            // simpler than repeating the function check_for_dragon
            // here there is a dragon nearby!
            return 0;
        } else if (maze[x][y] == 'E') {
            // this cell is the Exit. Check if Hero has the Key
            return 2;
        } else if (maze[x][y] == 'K') {
            return 3;
        } else if (maze[x][y] == 'X') {
            return 4;
        }

        return -1;
    }


    // Move Hero from (hx, hy) to (x,y), if possible!
    private static void move_from_to_cell(Coordinates hero, int x, int y) {
        int a = is_cell_free(x, y);

        if (a == -1) {
            // Trying to leave the maze limits
            System.out.println("Invalid Move");
        } else if (a == 0) {
            // Reached the dragon
            System.out.println("You DIED!");
            maze[x][y] = '(';
            maze[hero.hx][hero.hy] = ' ';
            is_game_over = true;
        } else if (a == 1) {
            // Move to a free place
            maze[x][y] = 'H';
            maze[hero.hx][hero.hy] = ' ';
        } else if (a == 2 && hero_has_key) {
            // Reached the exit and have the key!
            System.out.println("You WON!!");
            maze[x][y] = 'H';
            maze[hero.hx][hero.hy] = ' ';
            is_game_over = true;
        } else if (a == 3) {
            // Reached the Key
            maze[x][y] = 'H';
            maze[hero.hx][hero.hy] = ' ';
            hero_has_key = true;
        }


        if (a == 2 && !hero_has_key) {
            // Reached the exit without the key!
        } else if (a > -1 && a < 4) {
            // Update Hero Position
            hero.hx = x;
            hero.hy = y;
        }
    }


}


class Coordinates {
    int hx;
    int hy;

    public Coordinates(int hx, int hy) {
        this.hx = hx;
        this.hy = hy;
    }
}



