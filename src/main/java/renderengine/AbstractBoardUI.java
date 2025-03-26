package renderengine;

import javafx.scene.layout.Pane;

/**
 * Abstract base class for rendering a board UI.
 * This class provides a foundation for creating a visual representation of a board.
 * Subclasses are expected to provide specific implementations for rendering the board.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public abstract class AbstractBoardUI {

  /**
   * The root node that visually represents the board area.
   * This Pane serves as the container for all visual elements of the board.
   */
  protected Pane boardRoot = new Pane();

  /**
   * Subclasses implement how the board is drawn or updated.
   * This method should contain the logic for rendering or updating the board's visual representation.
   */
  public abstract void renderBoard();

  /**
   * Returns the root pane of the board UI.
   * This method provides access to the root Pane that contains the board's visual elements.
   *
   * @return the root Pane of the board UI
   */
  public Pane getBoardRoot() {
    return boardRoot;
  }
}