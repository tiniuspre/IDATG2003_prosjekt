package snakesandladders.engine.actions;

import gameengine.board.TileAction;

/**
 * The {@code SnakeAction} class represents the action,
 * of a snake in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see TileAction
 */
public class SnakeAction implements TileAction {
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
   * The action that should be performed when a player lands on the tile.
   *
   * @param position the position of the player.
   * @return the position of the player after the action.
   */
  @Override
  public int landAction(final int position) {
    return snakeTail;
  }
}

