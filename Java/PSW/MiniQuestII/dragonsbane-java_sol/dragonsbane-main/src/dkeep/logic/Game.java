package dkeep.logic;

import java.util.ArrayList;

import dkeep.logic.Maze.Direction;

public class Game {
  Maze maze;
  Hero hero;
  ArrayList<Dragon> dragons;
  Element sword;
  boolean has_key;
  String output_msg;

  public Game(int ndragons) {
    maze = new Maze();
    hero = new Hero(maze, 1, 1);
    sword  = new Element(maze, 8, 1);
  
    CreateDragons(ndragons);  
  }
  
  public char[][] GetMaze() {
    return maze.GetMaze();
  }
  
  public String GetOutputMessage() {
    return output_msg;
  }
  
  public boolean UpdateGame(char uc) {
    output_msg = "";
  
    switch (uc) {
    case 'w': return UpdateTurn(Direction.kNorth);
    case 's': return UpdateTurn(Direction.kSouth);
    case 'd': return UpdateTurn(Direction.kEast);
    case 'a': return UpdateTurn(Direction.kWest);
    }
  
    return false;  
  }
  

  private boolean UpdateTurn(Direction dir) {
    if (!TryExit(dir)) {
      hero.Move(dir);
      TryToPickSword();
      if ((!AreAllDragonsDead()) && (!DragonsKilledHero())) {
        return DragonsMove();
      } else if (AreAllDragonsDead()) return false;
      else return true;
    } else return true;  
  }
  
  private boolean AreAllDragonsDead() {
    for (Dragon dragon : dragons)
      if (dragon.IsAlive())
        return false;
    
    return true;
  }
  
  private void CreateDragons(int ndragons) {
    dragons = new ArrayList<Dragon>(ndragons);

    for (int i = 0; i < ndragons; i++) {
      dragons.add(i, new Dragon(maze, 1+i, 8));
      maze.PlaceElement('D', 1+i, 8);
    }
  }
  
  private boolean DragonsKilledHero() {
    for (Dragon dragon : dragons) {
      if ((dragon.IsAlive()) && (dragon.AdjacentTo(hero))) {
        if (hero.is_armed) {
          dragon.SetAlive(false);
          maze.ClearCell(dragon.GetX(), dragon.GetY());
          hero.SetHasKey(AreAllDragonsDead());
        } else {
          output_msg = "YOU DIED!";
          return true;
        }
      }
    }
    return false;  
  }
  
  private boolean DragonsMove() {
    for (Dragon dragon : dragons) {
      if (!dragon.IsAlive()) continue;
      dragon.Move();
    }
    return DragonsKilledHero();  
  }
  
  private void TryToPickSword() {
    if (hero.IsArmed()) return;
    hero.SetArmed(hero.Overlap(sword));  
  }
  
  private boolean TryExit(Direction dir) {
    int x = hero.GetX();
    int y = hero.GetY();
  
    boolean next_to_exit = maze.IsThere('E', x, y, dir);
    
    if (next_to_exit) {
      if (hero.HasKey()) {
        output_msg = "GREAT! YOU REACHED THE EXIT!";
        return true;
      } else {
        output_msg = "You need a key to open this door.";
        return false;
      }
    }
  
    return false;  
  }
}
