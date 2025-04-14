package snakesandladders.engine.actions;

import gameengine.player.Player;
import java.util.Map;

/**
 * The {@code Snake} class represents a snake action in the
 * snakes and ladders game.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 14.04.2025
 * @see SpecialAction
 */
public class Snake implements SpecialAction {
  /**
   * Map of snake positions where the key is the start position
   * and the value is the end position.
   */
  private final Map<Integer, Integer> snakePositions;

  /**
   * Constructor for Snake.
   *
   * @param snakeContext Map of snake positions.
   */
  public Snake(final Map<Integer, Integer> snakeContext) {
    this.snakePositions = snakeContext;
  }

  /**
   * Apply the snake action to the current player.
   *
   * @param currentPlayer The player who is currently taking their turn.
   */
  @Override
  public void apply(final Player currentPlayer) {
    // Store end and start positions for logging
    int endPos = snakePositions.get(currentPlayer.getPosition());
    int startPos = currentPlayer.getPosition();
    // Check if the end position is valid, else throw an exception
    if (endPos < startPos) {
      currentPlayer.setPosition(endPos);
    } else {
      throw new IllegalArgumentException("Invalid snake position: " + endPos);
    }
    System.out.println(currentPlayer.getName()
        + " hit a snake! Moved from " + startPos + " to " + endPos);
  }

}
