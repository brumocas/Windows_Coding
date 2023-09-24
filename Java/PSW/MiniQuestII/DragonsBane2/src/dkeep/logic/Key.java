package dkeep.logic;

public class Key extends Element{
    private static int tag = 5;

    // Constructor
    public Key(){

    }

    public static int getTag(){
        return tag;
    }

    public void setMap(Map map){
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.getElement(i, k) == 1 || map.getElement(i, k) == 2);
        map.setElement(i, k, Key.getTag());
        setCoordinates(i,k);
    }
}
