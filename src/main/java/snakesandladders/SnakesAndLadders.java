package snakesandladders;

import gameengine.Player;
import gameengine.dice.Dice;
import java.util.ArrayList;
import java.util.List;
import snakesandladders.engine.SnakesAndLaddersBoard;
import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.tiles.LadderTile;
import snakesandladders.engine.tiles.SnakeTile;

/**
 * The {@code TestGame} class represents the test snaked and ladders game.
 *
 * <p>The game is played on a board with snakes and ladders.
 * The players take turns to roll dice
 * and move their pieces on the board. If a player lands on a snake tile,
 * the player moves back to the tail of the snake.
 * If a player lands on a ladder tile, the player climbs the ladder to the top.
 * The game is won by the player who reaches the end of the board first.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see SnakesAndLaddersBoard
 * @see SnakesAndLaddersPlayer
 * @see Dice
 */
public class SnakesAndLadders {
  /**
   * The game board with width 10 and height 9.
   */
  private final SnakesAndLaddersBoard board = new SnakesAndLaddersBoard(10, 9);
  /**
   * The list of players in the game.
   */
  private final List<Player> players = new ArrayList<>();
  /**
   * The dice used in the game.
   */
  private final Dice dice = new Dice(2);

  /**
   * Sets up the game board with snakes and ladders.
   */
  public void setBoard() {
    board.createBoard();
  }

  /**
   * Adds a player to the game.
   *
   * @param name the name of the player.
   * @param piece the piece of the player.
   */
  public void addPlayer(final String name, final String piece) {
    players.add(new SnakesAndLaddersPlayer(name, piece));
  }

  /**
   * Plays one round of the game.
   */
  public void playOneRound() {
    for (Player player : players) {
      int roll = dice.rollDice();
      if (player.getPosition() + roll >= board.getBoardSize()) {
        player.setPosition(board.getBoardSize());
        System.out.println(player.getName()
            + " has reached the end of the board.");
      } else {
        player.move(roll);
      }
      if (board.getTile(player.getPosition())
          .getClass().equals(SnakeTile.class)) {
        SnakeTile snakeTile = (SnakeTile) board.getTile(player.getPosition());
        player.moveBack(snakeTile.getAction().landAction(player.getPosition()));
        System.out.println(player.getName()
            + " landed on a snake and moved back to position "
            + player.getPosition());
      } else if (board.getTile(player.getPosition())
          .getClass().equals(LadderTile.class)) {
        LadderTile ladderTile = (LadderTile)
            board.getTile(player.getPosition());
        player.move(ladderTile.getAction().landAction(player.getPosition()));
        System.out.println(player.getName()
            + " climbed a ladder to position " + player.getPosition());
      }
    }
  }

  /**
   * Prints the status of the players in the game with their current positions.
   */
  public void printStatus() {
    for (Player player : players) {
      System.out.println(player.getName()
          + " is at position " + player.getPosition());
    }
  }

  /**
   * Returns the winner of the game.
   *
   * @return the winner of the game.
   */
  public Player getWinner() {
    Player winner = players.getFirst();
    for (Player player : players) {
      if (player.getPosition() > winner.getPosition()) {
        winner = player;
      }
    }
    return winner;
  }

  /**
   * Returns true if the game is not finished.
   *
   * @return true if the game is not finished.
   */
  public boolean isNotFinished() {
    for (Player player : players) {
      if (player.getPosition() >= board.getBoardSize()) {
        return false;
      }
    }
    return true;
  }
}
