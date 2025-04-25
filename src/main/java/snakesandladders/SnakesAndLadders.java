package snakesandladders;

import constants.Constants;
import gameengine.board.Board;
import gameengine.board.BoardFactory;
import gameengine.dice.Dice;
import gameengine.player.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import snakesandladders.engine.actions.SpecialActionFactory;
import snakesandladders.engine.board.SnLBoard;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.engine.board.tile.SnLTile;

/**
 * The {@code SnakesAndLadders} class represents the snaked and ladders game.
 *
 * <p>The game is played on a board with snakes and ladders.
 * The players take turns to roll dice
 * and move their pieces on the board. If a player lands on a snake tile,
 * the player moves back to the tail of the snake.
 * If a player lands on a ladder tile, the player climbs the ladder to the top.
 * The game is won by the player who reaches the end of the board first.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 26.02.2025
 * @see SnLBoard
 * @see SnLPlayer
 * @see Dice
 */
public class SnakesAndLadders {
  /**
   * The game board for the Snakes and Ladders game.
   */
  private SnLBoard board;

  /**
   * The list of players in the game.
   */
  private final List<SnLPlayer> players = new ArrayList<>();
  /**
   * The dice used in the game.
   */
  private final Dice dice = new Dice(2);

  /**
   * Default constructor for the {@code SnakesAndLadders} class.
   */
  public SnakesAndLadders() {
  }

  /**
   * Sets up the game board with snakes and ladders.
   */
  public void setBoard() {
    Optional<Board> loadedBoard = BoardFactory.createBoard("snl", "classic");
    if (loadedBoard.isPresent()) {
      board = (SnLBoard) loadedBoard.get();
    } else {
      throw new IllegalArgumentException("Failed to load the board.");
    }
  }

  /**
   * Adds a player to the game.
   *
   * @param name the name of the player.
   * @param piece the piece of the player.
   */
  public void addPlayer(final String name, final String piece) {
    players.add(new SnLPlayer(name, piece));
  }

  /**
   * Plays one round of the game.
   */
  public void playOneRound() {
    for (SnLPlayer player : players) {
      int roll = dice.rollDice();
      if (player.getPosition() + roll >= board.getBoardSize()) {
        reachedEndOfBoard(player);
      } else {
        player.move(roll);
        System.out.println(player.getName()
            + " rolled a " + roll
            + " and moved to position " + player.getPosition());
        checkSpecialTile(player);
      }
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

  /**
   * Checks if the player is on a special tile (snake, ladder, or switch).
   *
   * @param player the player to check.
   */
  public void checkSpecialTile(final Player player) {
    // Gets Player position
    int playerPos = player.getPosition();
    // Prepares a special action factory.
    SpecialActionFactory specialActionFactory =
        new SpecialActionFactory(players, player);
    // Gets the current tile of the player.
    SnLTile currentTile = board.getTile(playerPos);
    // Checks if the player is on a special tile and applies the action.
    if (board.getTile(playerPos).getType().equals(Constants.SNAKE)) {
      specialActionFactory.createSpecialAction(currentTile)
          .ifPresent(snake -> snake.apply(player));
    } else if (board.getTile(playerPos).getType().equals(Constants.LADDER)) {
      specialActionFactory.createSpecialAction(currentTile)
          .ifPresent(ladder -> ladder.apply(player));
    } else if (board.getTile(playerPos).getType().equals(Constants.SWITCH)) {
      specialActionFactory.createSpecialAction(currentTile)
          .ifPresent(switchAction -> switchAction.apply(player));
    }
  }
}
