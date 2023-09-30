package dkeep.cli;

import java.util.Scanner;

import dkeep.logic.*;

public class DragonsBane {
    public static void main(String[] args) throws Exception {

        // Game loop
        Scanner s = new Scanner(System.in);
        char uc;
        boolean is_game_over = false;

        int ndragons = AskNumberOfDragons(s);

        Game game = new Game(ndragons);

        do {

            // print the maze
            PrintMaze(game.GetMaze());

            // read user command
            System.out.print("cmd> ");
            uc = s.next().charAt(0);    // ignore the other characters

            // update the game
            is_game_over = game.UpdateGame(uc);
            if (!is_game_over)
                System.out.println(game.GetOutputMessage());

        } while ((!is_game_over) && (uc != 'q'));

        // final state of the game
        PrintMaze(game.GetMaze());
        System.out.println(game.GetOutputMessage());

        System.out.println("Exiting!");

        s.close();
    }

    private static int AskNumberOfDragons(Scanner s) {
        do {
            System.out.print("How many dragons in the maze? (1-4) ");

            String n = s.next();

            try {
                int nd = Integer.parseInt(n);
                if ((nd <= 0) || (nd > 4))
                    throw new NumberFormatException();

                return nd;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        } while (true);
    }

    private static void PrintMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            // - print the maze coordinate (i,j)
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
                System.out.print(' ');
            }

            // - add linebreak after each line of the maze
            System.out.println();
        }
    }
}
