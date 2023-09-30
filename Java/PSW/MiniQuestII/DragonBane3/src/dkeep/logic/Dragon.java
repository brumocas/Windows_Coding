package dkeep.logic;

import dkeep.random.RandomNumber;

public class Dragon extends Element {
    private boolean isAlvive = true;
    private final char tag = 'D';


    // Constructor
    public Dragon() {

    }

    // Kill Dragon
    public void Kill() {
        this.isAlvive = false;
    }

    // Dragon alive status
    public boolean isAlive() {
        return this.isAlvive;
    }

    // tag getter
    @Override
    public char tag() {
        return this.tag;
    }

    // Set Dragon random map pos
    public void setMap(Map map) {
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.get(i, k) == 'x' || map.get(i, k) == 'H' || map.get(i, k) == 'D'
                || map.get(i, k) == 'E' || map.get(i, k) == 'S' || forbiddenDragonPos(i, k, map));
        set(i, k, map);
    }

    // Dragon forbidden positions
    public boolean forbiddenDragonPos(int i, int k, Map map) {

        // Dragon can´t block the exit
        if ((i == 4 || i == 5 || i == 6) && k == 8)
            return true;

        // Forbidden pos for the dragon, can produce deadlocks
        if (((i == 6 || i == 5 || i == 4) && k == 1) || (i == 5 && k == 2))
            return true;

        // Dragon is near the Sword
        if (map.get(i - 1, k) == 'S' || map.get(i + 1, k) == 'S' || map.get(i, k - 1) == 'S'
                || map.get(i, k + 1) == 'S')
            return true;

        // Dragon is near the Hero
        if (map.get(i - 1, k) == 'H' || map.get(i + 1, k) == 'H' || map.get(i, k - 1) == 'H'
                || map.get(i, k + 1) == 'H')
            return true;

        return false;
    }


    // Move Dragon randomly
    public int move(Map map, Hero hero, Dragon dragon) {
        int i, k;

        do {
            do {
                i = X() + RandomNumber.randomMove();
                k = Y() + RandomNumber.randomMove();
            } while (!Dimensions.check(i, k, map.length()));

        } while (!possibleMove(i, k, map));


        // Check if you kill the hero
        // Check if you are going to hit the adjacent dragon squares and can kill him
        if (Dimensions.check(i, k, map.length())) {
            if (map.get(i - 1, k) == hero.tag() || map.get(i + 1, k) == hero.tag()
                    || map.get(i, k - 1) == hero.tag() || map.get(i, k + 1) == hero.tag()) {
                if (hero.hasSword()) {
                    // You kill the Dragon
                    System.out.println("Dragon Killed 2");
                    map.killDragon(dragon);
                    map.set(hero.X(), hero.Y(), hero.tag());
                    map.set(X(), Y(), ' ');
                    return 1;
                } else {
                    // You die, no Sword
                    return 0;
                }
            }
        }

        map.set(X(), Y(), ' ');
        set(i,k,map);

        return 1;
    }

    public boolean possibleMove(int i, int k, Map map) {

        return map.get(i, k) != 'D' && map.get(i, k) != 'x' && map.get(i, k)
                != 'E' && !samePos(i, k);
    }

    public boolean samePos(int i, int k) {
        return (X() == i && Y() == k) || (X() != i && Y() != k);
    }

}
