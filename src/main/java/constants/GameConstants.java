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

  private GameConstants() {
    throw new IllegalStateException("Should not be instantiated");
  }
}
