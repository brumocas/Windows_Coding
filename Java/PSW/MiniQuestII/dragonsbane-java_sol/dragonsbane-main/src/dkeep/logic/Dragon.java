package dkeep.logic;

import dkeep.logic.Maze.Direction;

public class Dragon extends MoveableElement {
  boolean alive;
  boolean over_sword;

  public Dragon(Maze maze, int x, int y) {
    super(maze, x, y);
    alive = true;
    over_sword = false;
  }

  public boolean IsAlive() {
    return alive;
  }
  
  public void SetAlive(boolean alive) {
    this.alive = alive;
  }
  
  public void Move() {
    int here_x = x;
    int here_y = y;
  
    Direction dir = Direction.values()[(int)(Math.random()*4)];
  
    if (over_sword) {
      if (Move('D', dir)) {
        maze.PlaceElement('S', here_x, here_y);
        over_sword = false;
      }
      return;
  
    } else {
      if (maze.IsThere('S', here_x, here_y, dir)) {
        Move('F', dir);
        over_sword = true;
      }
    }
    Move('D', dir);  
  }
}
