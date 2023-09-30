package dkeep.logic;

import dkeep.cli.Cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public void Run(){
        System.out.println("Dragons Bane Game");
        System.out.println("Insert the number of Dragons:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        // Array for dragons
        List<Dragon> army = new ArrayList<>();

        // Create game objects instances
        Map map = new Map();
        Hero hero = new Hero();
        Sword sword = new Sword();
        for (int i = 0; i < num; i++) {
            Dragon dragon = new Dragon();
            army.add(dragon);
        }

        // Set maze number of dragons
        map.setAliveDragons(num);

        // Set elements int a random pos
        hero.setMap(map);
        sword.setMap(map);
        for (Dragon dragon : army) {
            dragon.setMap(map);
        }



        char movement;
        int move_status = 1;

        outerLoop:
        do {

            // Print the maze
            map.print();

            if (move_status == 2) {
                map.print();
                System.out.println("You Win \uD83D\uDE0A");
                break outerLoop;
            }

            if (move_status == 0) {
                map.print();
                System.out.println("Game Over \uD83D\uDE22");
                break outerLoop;
            }

            if (move_status == -1){
                System.out.println("ERROR 404");
                break outerLoop;
            }

            movement = Cmd.getCmd();

            // Move Hero
            move_status = hero.move(map, movement, army, sword);

            // Move Dragons
            for (Dragon dragon : army){
                if (dragon.isAlive()){
                    move_status = dragon.move(map,hero,dragon);
                }
            }

        }
        while (movement != 'q' && movement != 'Q');
    }

}
