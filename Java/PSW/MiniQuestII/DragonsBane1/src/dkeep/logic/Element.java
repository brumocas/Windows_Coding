package dkeep.logic;

public abstract class Element {
    private int x = 0;
    private int y = 0;

    public void setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getCoordinateX(){
        return this.x;
    }

    public int getCoordinateY(){
        return this.y;
    }

}
