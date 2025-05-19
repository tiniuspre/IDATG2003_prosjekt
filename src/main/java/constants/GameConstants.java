package constants;

/**
 * Utility class containing constants.
 * This class should not be instantiated.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public final class GameConstants {
  /**
   * The size of the Tic Tac Toe board.
   */
  public static final int TTT_BOARD_SIZE = 3;

  /**
   * Title of the Tic Tac Toe game.
   */
  public static final String TTT_TITLE = "Tic Tac Toe";

  private GameConstants() {
    throw new IllegalStateException("Should not be instantiated");
  }
}
