package dkeep.logic;

import dkeep.random.RandomNumber;

public class Sword extends Element{
    private static int tag = 5;

    // Constructor
    public Sword(){

    }

    // get sword tag number
    public static int getTag(){
        return tag;
    }

    // Set sword random pos
    public void setMap(Map map){
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.getElement(i, k) == 1 || map.getElement(i, k) == 2);
        map.setElement(i, k, Sword.getTag());
        setCoordinates(i,k);
    }
}
