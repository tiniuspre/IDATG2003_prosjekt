package renderengine;

import javafx.scene.Node;

/**
 * Abstract base class for rendering a player or piece on the board.
 * Subclasses should provide specific implementations for creating
 * and updating the player's visual representation.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public abstract class AbstractPlayerUI {

  /**
   * Returns the visual representation of the player or piece.
   * Could be an ImageView, a Shape, or any JavaFX node.
   *
   * @return a Node representing the player/piece.
   */
  public abstract Node createPlayerNode();

  /**
   * Moves or updates the player's node position on the board.
   *
   * @param newX the new X coordinate.
   * @param newY the new Y coordinate.
   */
  public abstract void updatePlayerPosition(double newX, double newY);

  /**
   * Optionally, update the player UI (e.g., label) or styling.
   *
   * @param info some player info to display.
   */
  public abstract void updatePlayerInfo(Object info);
}
