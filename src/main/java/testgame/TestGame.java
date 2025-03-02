package testgame;

import gameengine.dice.Dice;
import testgame.engine.Player;
import testgame.engine.TestGameBoard;
import testgame.engine.tiles.SnakeTile;
import testgame.engine.tiles.LadderTile;

import java.util.ArrayList;
import java.util.List;

public class TestGame {

  private final TestGameBoard board = new TestGameBoard(10,9);
  private final List<Player> players = new ArrayList<>();
  private final Dice dice = new Dice(2);

  public void setBoard() {
    board.createBoard();
    board.addSnakeTiles();
    board.addLadderTiles();
  }

  public void addPlayer(String name) {
    players.add(new Player(name));
  }

  public void playOneRound() {
    for (Player player : players) {
      int roll = dice.rollDice();
      if (player.getPosition() + roll >= board.getBoardSize()) {
        player.setPosition(board.getBoardSize());
        System.out.println(player.getName() + " has reached the end of the board.");
      } else {
        player.move(roll);
      }
      if (board.getTile(player.getPosition()).getClass().equals(SnakeTile.class)) {
        SnakeTile snakeTile = (SnakeTile) board.getTile(player.getPosition());
        player.moveBack(snakeTile.getAction().landAction(player.getPosition()));
        System.out.println(player.getName() + " landed on a snake and moved back to position " + player.getPosition());
      } else if (board.getTile(player.getPosition()).getClass().equals(LadderTile.class)) {
        LadderTile ladderTile = (LadderTile) board.getTile(player.getPosition());
        player.move(ladderTile.getAction().landAction(player.getPosition()));
        System.out.println(player.getName() + " climbed a ladder to position " + player.getPosition());
      }
    }
  }

  public void printStatus() {
    for (Player player : players) {
      System.out.println(player.getName() + " is at position " + player.getPosition());
    }
  }

  public Player getWinner() {
    Player winner = players.getFirst();
    for (Player player : players) {
      if (player.getPosition() > winner.getPosition()) {
        winner = player;
      }
    }
    return winner;
  }

  public boolean isFinished() {
    for (Player player : players) {
      if (player.getPosition() >= board.getBoardSize()) {
        return true;
      }
    }
    return false;
  }
}
