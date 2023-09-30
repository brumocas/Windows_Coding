package dkeep.logic;

import dkeep.random.RandomNumber;

import java.util.List;

public class Hero extends Element {
    private static int tag = 2 ;
    private boolean wSword = false;

    // Constructor
    public Hero() {

    }

    // Get Hero tag number
    public static int getTag() {
        return tag;
    }

    // Hero equips the sword
    public void getSword() {
        wSword = true;
    }

    // Check if Hero has the sword
    public boolean swordStatus() {
        return wSword;
    }

    // Set Hero Random position
    public void setMap(Map map) {
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.getElement(i, k) == 1 || map.getElement(i, k) == 4);
        map.setElement(i, k, Hero.getTag());
        setCoordinates(i, k);
    }

    // Function to move the Hero position
    public int move(Map map, char movement, List<Dragon> army, Sword sword) {
        // Find Hero position
        int i, k;
        i = getCoordinateX();
        k = getCoordinateY();

        return switch (movement) {
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
        if (!swordStatus() && (sword.getCoordinateX() == i) && (sword.getCoordinateY()) == k) {
            getSword();
        }

        // Check if you are able to exit
        if (map.statusDragons() && map.getElement(i, k) == Map.getExit()) {
            map.setElement(i, k, Hero.getTag());
            map.setElement(getCoordinateX(), getCoordinateY(), Map.getSpace());
            setCoordinates(i, k);
            return 2;
        }

        // Check for each dragon if you hit them
        for (Dragon dragon : army) {
            if (checkCollision(i, k, dragon.getCoordinateX(), dragon.getCoordinateY())) {
                if (swordStatus()) {
                    //You Kill the Dragon
                    System.out.println("Dragon Killed 1");
                    map.killDragon();
                    dragon.kill();
                    map.setElement(getCoordinateX(),getCoordinateX(),Map.getSpace());
                    map.setElement(dragon.getCoordinateX(), dragon.getCoordinateY(), Map.getSpace());
                    map.setElement(i, k, Hero.getTag());
                    setCoordinates(i, k);
                    return 1;
                }
                else {
                    // You die, no Sword
                    return 0;
                }
            }
        }

        // Check if you hit the edge or exit
        if (map.getElement(i, k) != Map.getWall() && map.getElement(i, k) != Map.getExit()) {
            map.setElement(i, k, Hero.getTag());
            map.setElement(getCoordinateX(), getCoordinateY(), Map.getSpace());
            setCoordinates(i, k);
            return 1;
        }

        return 1;
    }


    public boolean checkCollision(int i, int k, int x, int y) {

        return ((i - 1 == x) && (k == y)) || ((i + 1 == x) && (k == y)) || ((i == x) && (k - 1 == y)) || ((i == x) && (k + 1 == y));
    }


}