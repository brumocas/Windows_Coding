package dkeep.logic;

import dkeep.logic.Maze.Direction;

public class MoveableElement extends Element {
  public MoveableElement(Maze maze, int x, int y) {
    super(maze, x, y);
  }

  public boolean Move(char ch, Direction dir) {
    int delta_x = 0;
    int delta_y = 0;
  
    // Check direction
    if (dir == Direction.kNorth) delta_x = -1;
    if (dir == Direction.kSouth) delta_x = 1;
    if (dir == Direction.kEast) delta_y = 1;
    if (dir == Direction.kWest) delta_y = -1;
  
    // Check if it is possible to move the hero in the maze
    if (maze.CanMoveInto(x + delta_x, y + delta_y)) {
      // - update representation in the maze
      maze.MoveElement(ch, x, y, x + delta_x, y + delta_y);
  
      // - update pose (x,y)
      x += delta_x;
      y += delta_y;
  
      return true;
  
    }
  
    return false;  
  }
}
