package dkeep.logic;

public class Hero extends Element {
    private static int tag = 2;
    private boolean key = false;

    // Constructor
    public Hero() {

    }

    public static int getTag() {
        return tag;
    }

    public void getKey() {
        key = true;
    }

    public boolean keyStatus() {
        return key;
    }

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

        // Check if you pick the key
        if (!keyStatus() && map.getElement(i, k) == Key.getTag()) {
            getKey();
        }

        // Check if you are able to exit
        if (keyStatus() && map.getElement(i,k) == Map.getExit()){
            map.setElement(i,k,Hero.getTag());
            map.setElement(getCoordinateX(),getCoordinateY(), Map.getSpace());
            setCoordinates(i,k);
            return 2;
        }

        // Check if you are going to hit the adjacent dragon squares
        if (Dimensions.check(i , k , map.getLength())) {
            if (map.getElement(i - 1, k) == Dragon.getTag() || map.getElement(i + 1, k) == Dragon.getTag()
                    || map.getElement(i, k - 1) == Dragon.getTag() || map.getElement(i, k + 1) == Dragon.getTag()) {
                map.setElement(i,k,Hero.getTag());
                map.setElement(getCoordinateX(),getCoordinateY(), Map.getSpace());
                setCoordinates(i,k);
                return 0;
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
}

