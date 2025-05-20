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

  /**
   * The size of the Connect Four board.
   */
  public static final String CF_TITLE = "Connect Four";
  /**
   * The size of the Connect Four board.
   */
  public static final int CF_BOARD_SIZE = 7;
  /**
   * The number of markers in a row needed to win.
   */
  public static final int CONNECT_WIN_LENGTH = 4;

  private GameConstants() {
    throw new IllegalStateException("Should not be instantiated");
  }
}
