package snakesandladders.engine.actions;

import gameengine.player.Player;

/**
 * Interface representing a special action in the Snakes and Ladders game.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 14.04.2025
 * @see Ladder
 * @see Snake
 * @see Switch
 */
public interface SpecialAction {
  /**
   * Applies the special action to the current player.
   *
   * @param currentPlayer The player who is currently taking their turn.
   */
  void apply(Player currentPlayer);
}
