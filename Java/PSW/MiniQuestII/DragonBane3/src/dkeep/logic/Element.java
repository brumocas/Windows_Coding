package dkeep.logic;

public abstract class Element {
    private int x = 0;
    private int y = 0;

    public void set(int x, int y, Map map){
        // Place in the map
        map.set(x,y,tag());

        // Actualize coordinates
        this.x = x;
        this.y = y;
    }

    public int X(){
        return this.x;
    }

    public int Y(){
        return this.y;
    }

    public char tag(){
        return '_';
    }

}