package dkeep.cli;

import dkeep.logic.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {

    public static void run() {
        System.out.println("Dragons Bane Game");
        System.out.println("Insert the number of Dragons:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        // Create map instance
        Map map = new Map();
        Hero hero = new Hero();
        Sword sword = new Sword();

        // Array for dragons
        List<Dragon> army = new ArrayList<>();

        // Set number of dragons
        map.setNumberDragons(num);

        for (int i = 0; i < num; i++) {
            Dragon dragon = new Dragon();
            army.add(dragon);
        }

        // Set Random Pos
        hero.setMap(map);
        sword.setMap(map);
        for (Dragon dragon : army) {
            dragon.setMap(map);
        }

        // Print the maze
        Print.maze(map);

        char movement;
        int move_status;

        outerLoop:
        do {
            movement = Cmd.getCmd();

            // Move Hero
            move_status = hero.move(map, movement, army, sword);

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

            // Move Dragons
            for (Dragon dragon : army) {
                System.out.println(dragon.isKill());
                if (dragon.isKill()){
                    continue ;
                }

                move_status = dragon.move(map, hero);

                if (move_status == 0) {
                    Print.maze(map);
                    System.out.println("Game Over \uD83D\uDE22");
                    break outerLoop;
                }
                System.out.println();
            }

            Print.maze(map);
        }
        while (movement != 'q' && movement != 'Q');

    }
}
