package dkeep.logic;

import dkeep.random.RandomNumber;

import java.net.http.HttpHeaders;

public class Dragon extends Element {
    private static int tag = 3;
    private boolean dragonDead = false;

    public Dragon() {

    }

    public static int getTag() {
        return tag;
    }

    public void kill(){
        dragonDead = true;
    }

    public boolean isKill(){
        return dragonDead;
    }

    public int move(Map map, Hero hero) {
        int i, k;

        do {
            do {
                i = getCoordinateX() + RandomNumber.randomMove();
                k = getCoordinateY() + RandomNumber.randomMove();
            } while (!Dimensions.check(i, k, map.getLength()));

        } while (!possibleMove(i, k, map));


        // Check if you kill the hero
        // Check if you are going to hit the adjacent dragon squares and can kill him
        if (Dimensions.check(i, k, map.getLength())) {
            if (map.getElement(i - 1, k) == Hero.getTag() || map.getElement(i + 1, k) == Hero.getTag()
                    || map.getElement(i, k - 1) == Hero.getTag() || map.getElement(i, k + 1) == Hero.getTag()) {
                if (hero.swordStatus()) {
                    // You kill the Dragon
                    System.out.println("Dragon Killed 2");
                    map.killDragon();
                    kill();
                    map.setElement(getCoordinateX(), getCoordinateY(), Map.getSpace());
                    map.setElement(hero.getCoordinateX(),hero.getCoordinateY(), Hero.getTag());
                    return 1;
                } else {
                    // You die, no Sword
                    return 0;
                }
            }
        }

        map.setElement(getCoordinateX(), getCoordinateY(), Map.getSpace());
        map.setElement(i, k, Dragon.getTag());
        setCoordinates(i, k);

        return 1;
    }

    public boolean possibleMove(int i, int k, Map map) {

        return map.getElement(i, k) != Dragon.getTag() && map.getElement(i, k) != Map.getWall() && map.getElement(i, k)
                != Map.getExit() && !samePos(i, k);
    }
    public boolean samePos(int i, int k) {
        return (getCoordinateX() == i && getCoordinateY() == k) || (getCoordinateX() != i && getCoordinateY() != k);
    }

    public void setMap(Map map) {
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.getElement(i, k) == Map.getExit() || map.getElement(i, k) == Hero.getTag() || map.getElement(i, k) == Dragon.getTag()
                || map.getElement(i, k) == Map.getWall() || map.getElement(i, k) == Sword.getTag() || forbiddenDragonPos(i, k, map));
        map.setElement(i, k, Dragon.getTag());
        setCoordinates(i, k);
    }

    public boolean forbiddenDragonPos(int i, int k, Map map) {

        // Dragon can´t block the exit
        if ((i == 4 || i == 5 || i == 6) && k == 8)
            return true;

        // Forbidden pos for the dragon, can produce deadlocks
        if (((i == 6 || i == 5 || i == 4) && k == 1) || (i == 5 && k == 2))
            return true;

        // Dragon is near the key
        if (map.getElement(i - 1, k) == Sword.getTag() || map.getElement(i + 1, k) == Sword.getTag() || map.getElement(i, k - 1) == Sword.getTag()
                || map.getElement(i, k + 1) == Sword.getTag())
            return true;

        // Dragon is near the Hero
        if (map.getElement(i - 1, k) == Hero.getTag() || map.getElement(i + 1, k) == Hero.getTag() || map.getElement(i, k - 1) == Hero.getTag()
                || map.getElement(i, k + 1) == Hero.getTag())
            return true;

        return false;
    }

}
