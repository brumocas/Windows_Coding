classDiagram
direction BT
class AboutUs {
  + AboutUs() 
   ActionEvent menuScene
}
class Board {
  + Board() 
  - Vector~String~ leftparams
  - Vector~String~ upparams
  + eraseBoard() void
  + getLeftparams(int) String
  + getPlayer(int, int) String
  + getSymbol(int, int) char
  + getUpparams(int) String
  + isEmpty(int, int) boolean
  + print() void
  + print_char() void
  + setPlay(int, int, String, char) void
   Vector~String~ leftparams
   Communication params
   Vector~String~ upparams
}
class Client {
  + Client() 
  + main(String[]) void
  - playGui(String[]) void
  - playMusic() void
  - playWav(String, float) void
  - stopMusic() void
}
class Communication {
  + Communication() 
  + closeConnection() void
  + connectRemote(int) boolean
  + connectToServer(String, int) void
  + exchangeNames(String) String
  + receiveMessage() String
  + sendMessage(String) void
   String[] params
}
class Game {
  + Game() 
  - Label gameInfo
  ~ changeImage(ImageView, String) void
  ~ changeParams(Label, String) void
  ~ changeShirt(ImageView, char) void
  ~ changeTextFieldToGuess() void
  ~ changeTextFieldToWait() void
  + checkTimer() int
  ~ delay() void
  - gameCycle() void
  ~ gameEnded() boolean
  ~ getMessage(KeyEvent) void
  ~ getOpponentPlay() void
  ~ getParamPath(String) String
  ~ getUIplay() void
  ~ increaseLeftScore() void
  ~ increaseRightScore() void
  + loadNames() String[]
  ~ makeGuessF1(KeyEvent) void
  ~ makeGuessF2(KeyEvent) void
  ~ makeGuessF3(KeyEvent) void
  ~ makeGuessF4(KeyEvent) void
  ~ makeGuessF5(KeyEvent) void
  ~ makeGuessF6(KeyEvent) void
  ~ makeGuessF7(KeyEvent) void
  ~ makeGuessF8(KeyEvent) void
  ~ makeGuessF9(KeyEvent) void
  ~ receiveMessage(String) void
  ~ removeGameInfo() void
  ~ removeTextField(TextField, Label, String) void
  ~ resetGame() void
  + setGameLogic(boolean, Communication, Player, Player) void
  ~ setMenuButton() void
  + startTimer() void
  + stopTimer() void
  ~ suggestionTextFields(TextField[][]) void
  ~ updateParamsTeams() void
  - updateUI(TextField[][], ImageView[][], Label[][]) void
   String gameInfo
   ActionEvent menuScene
}
class Gui {
  + Gui() 
  - Gui instance
  + main(String[]) void
  + start(Stage) void
   Gui instance
}
class Icon {
  + Icon() 
   Stage icon
}
class Instructions {
  + Instructions() 
  - hyperlink(ActionEvent) void
   ActionEvent menuScene
}
class Joingame {
  + Joingame() 
   ActionEvent menuScene
   ActionEvent waitingRoomScene
}
class Menu {
  + Menu() 
  + exitMenuScene(ActionEvent) void
  + initialize(URL, ResourceBundle) void
   ActionEvent aboutUsScene
   ActionEvent instructionsScene
   ActionEvent joinGameScene
   ActionEvent newGameScene
}
class Newgame {
  + Newgame() 
   ActionEvent menuScene
   ActionEvent waitingRoomScene
}
class Player {
  + Player(String, char) 
  + Player() 
  - String guess
  - boolean inGame
  - String name
  - char symbol
  - int x
  - int y
  + print() void
  + setPosition(int, int) void
   String guess
   boolean inGame
   String name
   char symbol
   int x
   int y
}
class WaitingRoom {
  + WaitingRoom() 
  + setHost(String, String) void
  + setHosted(String, String, Communication) void
   ActionEvent gameScene
   ActionEvent menuScene
}
class checkClient2Connection {
  + checkClient2Connection(Communication) 
  # call() Void?
}

Game "1" *--> "board 1" Board 
Game  ..>  Board : «create»
Game  ..>  Communication : «create»
Game "1" *--> "chat 1" Communication 
Game "1" *--> "p1 1" Player 
Joingame "1" *--> "client2 1" Communication 
Joingame  ..>  Communication : «create»
WaitingRoom  ..>  Communication : «create»
WaitingRoom "1" *--> "client1 1" Communication 
WaitingRoom "1" *--> "p1 1" Player 
WaitingRoom  ..>  Player : «create»
WaitingRoom  ..>  checkClient2Connection : «create»
checkClient2Connection "1" *--> "client1 1" Communication 
WaitingRoom  -->  checkClient2Connection 
