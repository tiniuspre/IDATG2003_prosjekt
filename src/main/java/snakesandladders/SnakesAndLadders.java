package snakesandladders;

import gameengine.player.Player;
import gameengine.dice.Dice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import snakesandladders.engine.SnakesAndLaddersBoard;
import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.SnakesLaddersLoader;
import snakesandladders.engine.actions.SpecialActionFactory;

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
 * @since 26.02.2025
 * @see SnakesAndLaddersBoard
 * @see SnakesAndLaddersPlayer
 * @see Dice
 */
public class SnakesAndLadders {

  private SnakesAndLaddersBoard board;

  /**
   * The list of players in the game.
   */
  private final List<SnakesAndLaddersPlayer> players = new ArrayList<>();
  /**
   * The dice used in the game.
   */
  private final Dice dice = new Dice(2);

  public SnakesAndLadders() {
  }

  /**
   * Sets up the game board with snakes and ladders.
   */
  public void setBoard() throws IOException {
    board = SnakesLaddersLoader.loadBoard("Classic");
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
    for (SnakesAndLaddersPlayer player : players) {
      int roll = dice.rollDice();
      if (player.getPosition() + roll >= board.getBoardSize()) {
        reachedEndOfBoard(player);
      } else {
        player.move(roll);
      }
      System.out.println(player.getName()
          + " rolled a " + roll
          + " and moved to position " + player.getPosition());
      checkSpecialTile(player);
    }
  }

  /**
   * Moves the player to the end of the board.
   *
   * @param player the player to move to the end of the board.
   */
  public void reachedEndOfBoard(final Player player) {
    player.setPosition(board.getBoardSize());
    System.out.println(player.getName()
        + " has reached the end of the board.");
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

  public void checkSpecialTile(final Player player) {
    Integer playerPos = player.getPosition();
    SpecialActionFactory specialActionFactory = new SpecialActionFactory(board, players, player);
    if (board.getSnakes().containsKey(playerPos)) {
      specialActionFactory.createSpecialAction("Snake")
          .ifPresent(snake -> snake.apply(player));
    } else if (board.getLadders().containsKey(playerPos)) {
      specialActionFactory.createSpecialAction("Ladder")
          .ifPresent(ladder -> ladder.apply(player));
    } else if (board.getSwitches().contains(playerPos)) {
      specialActionFactory.createSpecialAction("Switch")
          .ifPresent(switchAction -> switchAction.apply(player));
    }
  }
}
