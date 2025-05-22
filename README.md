# IDATG2003
### Authors
###### @tiniuspre, @jonasaatomren

## About
This is a JavaFX project that implements three games: Connect Four, Tic Tac Toe, and Snakes and Ladders. The project is designed to be modular, allowing for easy addition of new games in the future.


## Commands
### How to Run
```bash
mvn clean javafx:run
```

### Test
```bash
mvn test
```

## Map of /src
```text
.
├── java
│         ├── connectfour
│         │         ├── engine
│         │         │         ├── ConnectFourBoard.java
│         │         │         ├── ConnectFourGame.java
│         │         │         └── package-info.java
│         │         ├── package-info.java
│         │         └── ui
│         │             ├── ConnectFourApp.java
│         │             ├── ConnectFourController.java
│         │             ├── ConnectFourView.java
│         │             └── package-info.java
│         ├── constants
│         │         ├── Constants.java
│         │         ├── GameConstants.java
│         │         ├── UiConstants.java
│         │         └── package-info.java
│         ├── filehandler
│         │         ├── AbstractFileHandler.java
│         │         ├── FileHandlerException.java
│         │         ├── csvhandling
│         │         │         ├── CsvHandler.java
│         │         │         ├── CsvHandlerException.java
│         │         │         ├── CsvIgnore.java
│         │         │         ├── CsvUtils.java
│         │         │         └── package-info.java
│         │         ├── jsonhandling
│         │         │         ├── JsonHandler.java
│         │         │         ├── JsonHandlerException.java
│         │         │         └── package-info.java
│         │         └── package-info.java
│         ├── gameengine
│         │         ├── BaseIllegalArgumentException.java
│         │         ├── Engine.java
│         │         ├── Observer.java
│         │         ├── Subject.java
│         │         ├── board
│         │         │         ├── BaseBoardException.java
│         │         │         ├── Board.java
│         │         │         ├── BoardFactory.java
│         │         │         ├── BoardLoadException.java
│         │         │         ├── BoardLoader.java
│         │         │         ├── package-info.java
│         │         │         └── tile
│         │         │             ├── Tile.java
│         │         │             └── package-info.java
│         │         ├── dice
│         │         │         ├── Dice.java
│         │         │         ├── Die.java
│         │         │         └── package-info.java
│         │         ├── grid
│         │         │         ├── Cell.java
│         │         │         ├── GridBoard.java
│         │         │         ├── GridGame.java
│         │         │         ├── GridPlayer.java
│         │         │         ├── Marker.java
│         │         │         └── package-info.java
│         │         ├── package-info.java
│         │         ├── player
│         │         │         ├── Player.java
│         │         │         ├── PlayerSelector.java
│         │         │         ├── PlayerUtil.java
│         │         │         └── package-info.java
│         │         └── scoreboard
│         │             ├── ScoreboardRegister.java
│         │             └── package-info.java
│         ├── module-info.java
│         ├── snakesandladders
│         │         ├── SnakesAndLadders.java
│         │         ├── SnakesAndLaddersApp.java
│         │         ├── engine
│         │         │         ├── SnLGameContext.java
│         │         │         ├── SnLPiece.java
│         │         │         ├── SnLPlayer.java
│         │         │         ├── actions
│         │         │         │         ├── Ladder.java
│         │         │         │         ├── Snake.java
│         │         │         │         ├── SpecialAction.java
│         │         │         │         ├── SpecialActionException.java
│         │         │         │         ├── SpecialActionFactory.java
│         │         │         │         ├── Switch.java
│         │         │         │         └── package-info.java
│         │         │         ├── board
│         │         │         │         ├── SnLBoard.java
│         │         │         │         ├── SnLBoardConfig.java
│         │         │         │         ├── SnLBoardException.java
│         │         │         │         ├── SnLLoader.java
│         │         │         │         ├── SnLTileChecker.java
│         │         │         │         ├── package-info.java
│         │         │         │         └── tile
│         │         │         │             ├── Jump.java
│         │         │         │             ├── SnLTile.java
│         │         │         │             └── package-info.java
│         │         │         └── package-info.java
│         │         ├── package-info.java
│         │         └── ui
│         │             ├── SnLController.java
│         │             ├── SnLView.java
│         │             ├── SnakesAndLaddersPlayerUI.java
│         │             ├── SnakesAndLaddersTileUI.java
│         │             └── package-info.java
│         ├── tictactoe
│         │         ├── engine
│         │         │         ├── TicTacToeBoard.java
│         │         │         ├── TicTacToeGame.java
│         │         │         └── package-info.java
│         │         └── ui
│         │             ├── TicTacToeApp.java
│         │             ├── TicTacToeController.java
│         │             ├── TicTacToeView.java
│         │             └── package-info.java
│         └── ui
│             ├── GameId.java
│             ├── MainMenu.java
│             ├── PlayerMenu.java
│             ├── ScoreBoardUi.java
│             ├── SettingsMenu.java
│             ├── UIApplication.java
│             ├── exceptions
│             │         ├── CssLoaderException.java
│             │         ├── UILoaderException.java
│             │         └── package-info.java
│             ├── launcher
│             │         ├── Router.java
│             │         └── package-info.java
│             ├── package-info.java
│             └── util
│                 ├── CssLoader.java
│                 ├── DialogUtil.java
│                 ├── GameScreen.java
│                 └── package-info.java
└── resources
          └── style
              ├── menu.css
              ├── playermenu.css
              └── settings.css
```