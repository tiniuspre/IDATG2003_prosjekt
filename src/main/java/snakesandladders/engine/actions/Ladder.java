package snakesandladders.engine.actions;

import gameengine.player.Player;
import java.util.Map;

/**
 * The {@code Ladder} class represents a ladder action in the
 * snakes and ladders game.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 14.04.2025
 * @see SpecialAction
 */
public class Ladder implements SpecialAction {
  /**
   * Ladder positions map where the key is the starting position
   * and the value is the ending position.
   */
  private final Map<Integer, Integer> ladderPositions;

  /**
   * Constructor for Ladder.
   *
   * @param ladderContext Map of ladder positions.
   */
  public Ladder(final Map<Integer, Integer> ladderContext) {
    this.ladderPositions = ladderContext;
  }

  /**
   * Apply the ladder action to the current player.
   *
   * @param currentPlayer The player who is currently taking their turn.
   */
  @Override
  public void apply(final Player currentPlayer) {
    // Store end and start positions for logging
    int endPos = ladderPositions.get(currentPlayer.getPosition());
    int startPos = currentPlayer.getPosition();
    // Check if the end position is valid, else throw an exception
    if (endPos > startPos) {
      currentPlayer.setPosition(endPos);
    } else {
      throw new IllegalArgumentException("Invalid ladder position: " + endPos);
    }
    System.out.println(currentPlayer.getName()
        + " hit a ladder! Moved from " + startPos + " to " + endPos);
  }
}
