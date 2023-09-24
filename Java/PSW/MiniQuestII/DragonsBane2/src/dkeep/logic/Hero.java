package dkeep.logic;

import dkeep.random.RandomNumber;

public class Hero extends Element {
    private static int tag = 2;
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
    public int move(Map map, char movement) {
        // Find Hero position
        int i, k;
        i = getCoordinateX();
        k = getCoordinateY();

        return switch (movement) {
            case 'w' -> nextMove(i - 1, k, map);
            case 's' -> nextMove(i + 1, k, map);
            case 'a' -> nextMove(i, k - 1, map);
            case 'd' -> nextMove(i, k + 1, map);
            default -> {
                System.out.println("Invalid move");
                yield 1;
            }
        };
    }

    public int nextMove(int i, int k, Map map) {

        // Check if you pick the Sword
        if (!swordStatus() && map.getElement(i, k) == Sword.getTag()) {
            getSword();
        }

        // Check if you are able to exit
        if (map.statusDragons() && map.getElement(i, k) == Map.getExit()) {
            map.setElement(i, k, Hero.getTag());
            map.setElement(getCoordinateX(), getCoordinateY(), Map.getSpace());
            setCoordinates(i, k);
            return 2;
        }

        // Check if you are going to hit the adjacent dragon squares and can kill him
        if (Dimensions.check(i, k, map.getLength())) {
            if (map.getElement(i - 1, k) == Dragon.getTag() || map.getElement(i + 1, k) == Dragon.getTag()
                    || map.getElement(i, k - 1) == Dragon.getTag() || map.getElement(i, k + 1) == Dragon.getTag()) {
                if (swordStatus()) {
                    // You kill the Dragon
                    map.killDragon();
                    eraseDragon(i + 1, k, map);
                    eraseDragon(i - 1, k, map);
                    eraseDragon(i, k + 1, map);
                    eraseDragon(i, k - 1, map);
                    map.setElement(i, k, Hero.getTag());
                    map.setElement(getCoordinateX(), getCoordinateY(), Map.getSpace());
                    setCoordinates(i, k);
                    return 1;
                } else {
                    // You die, no Sword
                    map.setElement(i, k, Hero.getTag());
                    map.setElement(getCoordinateX(), getCoordinateY(), Map.getSpace());
                    setCoordinates(i, k);
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

    void eraseDragon(int i, int k, Map map) {
        if (map.getElement(i, k) == Dragon.getTag())
            map.setElement(i, k, Map.getSpace());
    }
}

