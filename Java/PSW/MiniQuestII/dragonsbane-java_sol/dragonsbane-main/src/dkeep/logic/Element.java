package dkeep.logic;



public class Element {
  Maze maze;
  int x;
  int y;

  public Element(Maze maze, int x, int y) {
    this.maze = maze;
    this.x = x;
    this.y = y;  
  }

  public int GetX() {
    return x;
  }

  public int GetY() {
    return y;
  }
  
  public void SetX(int x) {
    this.x = x;
  }
  
  public void SetY(int y) {
    this.y = y;
  }
  
  
  public boolean AdjacentTo(Element other) {
    if ((x-1 == other.x) && (y == other.y)) return true;   // north
    if ((x+1 == other.x) && (y == other.y)) return true;   // south
    if ((x == other.x) && (y+1 == other.y)) return true;   // east
    if ((x == other.x) && (y-1 == other.y)) return true;   // west
  
    return false;  
  }
  
  public boolean Overlap(Element other) {
    return ((x == other.x) && (y == other.y));
  }
}
