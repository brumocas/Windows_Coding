package dkeep.logic;

import dkeep.random.RandomNumber;

public class Sword extends Element{
    private final char tag = 'S';

    // Constructor
    public Sword(){

    }

    // Set Sword random map pos
    public void setMap(Map map){
        int i, k;
        do {
            i = RandomNumber.randomNumber();
            k = RandomNumber.randomNumber();
        }
        while (map.get(i, k) == 'x' || map.get(i, k) == 'H' || map.get(i,k) == 'E');
        set(i,k,map);
    }

    // tag getter
    @Override
    public char tag() {
        return this.tag;
    }


}
