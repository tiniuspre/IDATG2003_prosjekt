package renderengine;

import javafx.scene.Node;

/**
 * Abstract base class for rendering a single tile on the board.
 * Subclasses could define tile color, shape, or images.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public abstract class AbstractTileUI {

  /**
   * Creates and returns the JavaFX node for a tile.
   *
   * @return a Node representing the tile.
   */
  public abstract Node createTileNode();

  /**
   * Updates the tile node’s state (for example, color or highlight).
   *
   * @param state any state or parameter you need to pass in.
   */
  public abstract void updateTileState(Object state);
}
