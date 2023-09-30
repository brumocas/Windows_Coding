package dkeep.logic;

import dkeep.random.RandomNumber;

import java.util.List;

public class Hero extends Element {
    private boolean hasSword = false;
    private char tag = 'H';

    // Constructor
    public Hero() {

    }

    // tag getter
    @Override
    public char tag() {
        return this.tag;
    }

    // Change tag for armed
    public void armed(){
        this.tag = 'A';
    }

    // Set Sword to true
    public void getSword() {
        hasSword = true;
    }

    // Get sword status
    public boolean hasSword() {
        return hasSword;
    }

    // Set Hero random map pos
    public void setMap(Map map) {
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.get(i, k) == 'x' || map.get(i, k) == 'E');
        set(i, k, map);
    }

    // Move Hero
    public int move(Map map, char move, List<Dragon> army, Sword sword) {
        // Find Hero position
        int i, k;
        i = X();
        k = Y();

        return switch (move) {
            case 'w' -> nextMove(i - 1, k, map, army, sword);
            case 's' -> nextMove(i + 1, k, map, army, sword);
            case 'a' -> nextMove(i, k - 1, map, army, sword);
            case 'd' -> nextMove(i, k + 1, map, army, sword);
            default -> {
                System.out.println("Invalid move");
                yield 1;
            }
        };
    }

    public int nextMove(int i, int k, Map map, List<Dragon> army, Sword sword) {

        // Check if you pick the Sword
        if (!hasSword() && (sword.X() == i) && (sword.Y()) == k) {
            getSword();
            armed();
        }

        // Check if you are able to exit
        if (map.getAliveDragons() == 0 && map.get(i, k) == 'E') {
            return 2;
        }

        // Check for each dragon if you hit them
        for (Dragon dragon : army) {
            if (checkCollision(i, k, dragon.X(), dragon.Y())) {
                if (hasSword()) {
                    if(dragon.isAlive()){
                        //You Kill the Dragon
                        System.out.println("Dragon Killed 1");
                        map.killDragon(dragon);
                        map.set(dragon.X(),dragon.Y(), ' ');
                        map.set(X(),Y(), ' ');
                        set(i,k,map);
                        return 1;
                    }
                } else {
                    // You die, no Sword
                    return 0;
                }
            }
        }

        // Check if you hit the edge or exit
        if (map.get(i, k) != 'x' && map.get(i, k) != 'E') {
            map.set(X(), Y(), ' ');
            set(i,k,map);
            return 1;
        }

        return 1;
    }

    public boolean checkCollision(int i, int k, int x, int y) {

        return ((i - 1 == x) && (k == y)) || ((i + 1 == x) && (k == y)) || ((i == x) && (k - 1 == y)) || ((i == x) && (k + 1 == y));
    }

}
