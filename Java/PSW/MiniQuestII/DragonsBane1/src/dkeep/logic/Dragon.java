package dkeep.logic;


public class Dragon extends Element {
    private static int tag = 3;

    public Dragon() {

    }

    public static int getTag(){
        return tag;
    }

    public void setMap(Map map) {
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.getElement(i, k) == Map.getExit() || map.getElement(i, k) == Hero.getTag() || map.getElement(i, k) == Dragon.getTag()
                || map.getElement(i, k) == Map.getWall() || map.getElement(i, k) == Key.getTag() || forbiddenDragonPos(i, k, map));
        map.setElement(i, k, Dragon.getTag());
        setCoordinates(i,k);
    }

    public boolean forbiddenDragonPos(int i, int k, Map map) {

        // Dragon can´t block the exit
        if ((i == 4 || i == 5 || i == 6) && k == 8)
            return true;

        // Forbidden pos for the dragon, can produce deadlocks
        if (((i == 6 || i == 5 || i == 4) && k == 1) || (i == 5 && k == 2))
            return true;

        // Dragon is near the key
        if (map.getElement(i - 1, k) == Key.getTag() || map.getElement(i + 1, k) == Key.getTag() || map.getElement(i, k - 1) == Key.getTag()
                || map.getElement(i, k + 1) == Key.getTag())
            return true;

        // Dragon is near the Hero
        if (map.getElement(i - 1, k) == Hero.getTag() || map.getElement(i + 1, k) == Hero.getTag() || map.getElement(i, k - 1) == Hero.getTag()
                || map.getElement(i, k + 1) == Hero.getTag())
            return true;

        return false;
    }

}
