package dkeep.logic;

import dkeep.logic.Maze.Direction;

public class Hero extends MoveableElement {
  boolean is_armed;
  boolean has_key;
  char ch;

  public Hero(Maze maze, int x0, int y0) {
    super(maze, x0, y0);
    is_armed = false;
    has_key  = false;
    ch = 'H';
  }

  public boolean IsArmed() {
    return is_armed;
  }
  
  public boolean HasKey() {
    return has_key;
  }
  
  public void SetArmed(boolean is_armed) {
    this.is_armed = is_armed;
    if (is_armed) this.ch = 'A';
    maze.PlaceElement(ch, x, y);  
  }
  
  public void SetHasKey(boolean has_key) {
    this.has_key = has_key;
  }
  
  public void Move(Direction dir) {
    super.Move(ch, dir);
  }
}
