
package snakesandladders.engine.actions;

import gameengine.board.TileAction;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.List;

/**
 * The {@code SnakeAction} class represents the action,
 * of a snake in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see TileAction
 */
public class SnakeAction implements TileAction<SnakesAndLaddersPlayer, List<SnakesAndLaddersPlayer>> {
  /**
   * The head of the snake.
   */
  private int snakeHead;
  /**
   * The tail of the snake.
   */
  private int snakeTail;

  /**
   * Constructor for the SnakeAction class.
   *
   * @param inputSnakeHead the head of the snake.
   * @param inputSnakeTail the tail of the snake.
   */
  public SnakeAction(final int inputSnakeHead, final int inputSnakeTail) {
    setSnakeHead(inputSnakeHead);
    setSnakeTail(inputSnakeTail);
  }

  /**
   * Sets the head of the snake.
   *
   * @param inputSnakeHead the head of the snake.
   * @throws IllegalArgumentException if the snake head is less than 0.
   */
  public void setSnakeHead(final int inputSnakeHead)
      throws IllegalArgumentException {
    if (inputSnakeHead < 0) {
      throw new IllegalArgumentException("Snake head must be greater than 0.");
    }
    this.snakeHead = inputSnakeHead;
  }

  /**
   * Sets the tail of the snake.
   *
   * @param inputSnakeTail the tail of the snake.
   * @throws IllegalArgumentException if the snake tail is less than 0,
   *        or greater than snake head.
   */
  public void setSnakeTail(final int inputSnakeTail)
      throws IllegalArgumentException {
    if (inputSnakeTail < 0 || inputSnakeTail >= snakeHead) {
      throw new IllegalArgumentException("Snake "
          + "tail must be greater than 0 and less than snake head.");
    }
    this.snakeTail = inputSnakeTail;
  }

  /**
   * Gets the tail of the snake.
   *
   * @return the tail of the snake.
   */
  public int getSnakeTail() {
    return this.snakeTail;
  }

  /**
   * Gets the head of the snake.
   *
   * @return the head of the snake.
   */
  public int getSnakeHead() {
    return this.snakeHead;
  }

  /**
   * The action that should be performed when a player lands on the tile.
   *
   * @param player the player to be moved.
   */
  @Override
  public void landAction(SnakesAndLaddersPlayer player, List<SnakesAndLaddersPlayer> playerList) {
    player.setPosition(getSnakeTail());
  }
}