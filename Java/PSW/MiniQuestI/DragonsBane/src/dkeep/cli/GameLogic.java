package dkeep.cli;

import dkeep.logic.*;

public class GameLogic {

    public static void run() {

        // Create map instance
        Map map = new Map();
        Hero hero = new Hero();
        Key key = new Key();
        Dragon dragon = new Dragon();

        // Set Random Pos
        hero.setMap(map);
        key.setMap(map);
        dragon.setMap(map);


        // Print the maze
        System.out.println("Dragons Bane Game\n");
        Print.maze(map);

        char movement;
        int move_status;

        do {
            movement = Cmd.getCmd();

            move_status = hero.move(map,movement);

            if (move_status == 2) {
                Print.maze(map);
                System.out.println("You Win \uD83D\uDE0A");
                break;
            }

            if (move_status == 0) {
                Print.maze(map);
                System.out.println("Game Over \uD83D\uDE22");
                break;
            }

            Print.maze(map);
        }
        while (movement != 'q' && movement != 'Q');

    }
}
