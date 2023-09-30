package dkeep.logic;

public class Maze {
  char[][] maze = {{'X','X','X','X','X','X','X','X','X','X'},
                   {'X','H',' ',' ',' ',' ',' ',' ',' ','X'},
                   {'X',' ','X','X',' ','X',' ','X',' ','X'},
                   {'X',' ','X','X',' ','X',' ','X',' ','X'},
                   {'X',' ','X','X',' ','X',' ','X',' ','X'},
                   {'X',' ',' ',' ',' ',' ',' ','X',' ','E'},
                   {'X',' ','X','X',' ','X',' ','X',' ','X'},
                   {'X',' ','X','X',' ','X',' ','X',' ','X'},
                   {'X','S','X','X',' ',' ',' ',' ',' ','X'},
                   {'X','X','X','X','X','X','X','X','X','X'}};

  enum Direction {
    kNorth, kSouth, kEast, kWest
  };
  
  public char[][] GetMaze() {
    return maze;
  }

  public void ClearCell(int x, int y) {
    maze[x][y] = ' ';
  }

  public boolean IsExit(int x, int y) {
    return (maze[x][y] == 'E');
  }

  public boolean IsThere(char ch, int here_x, int here_y, Direction dir) {
    if ((dir == Direction.kNorth) && (maze[here_x-1][here_y] == ch))
      return true;
    if ((dir == Direction.kSouth) && (maze[here_x+1][here_y] == ch))
      return true;
    if ((dir == Direction.kEast) && (maze[here_x][here_y+1] == ch))
      return true;
    if ((dir == Direction.kWest) && (maze[here_x][here_y-1] == ch))
      return true;

    return false;
  }

  public boolean CanMoveInto(int x, int y) {
    return ((maze[x][y] == ' ') || (maze[x][y] == 'S'));
  }

  public void MoveElement(char ch, int sx, int sy, int dx, int dy) {
    ClearCell(sx, sy);
    maze[dx][dy] = ch;  
  }

  public void PlaceElement(char ch, int x, int y) {
    maze[x][y] = ch;
  }
}
