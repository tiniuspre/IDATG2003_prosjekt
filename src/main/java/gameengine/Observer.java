package gameengine;

import gameengine.player.Player;

/**
 * Observer interface for the Observer design pattern.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 25.04.2025
 */
public interface Observer {
  /**
   * Update method to be called when the subject changes.
   *
   * @param subject the player that has changed.
   */
  void update(Subject subject);
}
