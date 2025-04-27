package ui.util;

import javafx.scene.Parent;

/**
 * Interface representing a game screen.
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 27.04.2025
 */
public interface GameScreen {
  /**
   * Returns the view of the game screen.
   *
   * @return the Parent object representing the view.
   */
  Parent getView();
}
