package constants;


import java.util.List;

/**
 * Utility class containing constants.
 * This class should not be instantiated.
 *
 * @author tiniuspre, jonastomren
 * @version 25.04.2025
 * @since 25.03.2025
 */
public final class Constants {

  // File paths
  /**
   * Path to the Snakes and Ladders board JSON file.
   */
  public static final String BOARD_FILE_PATH =
      "boards/boards.json";

  // CSV Field Settings
  /**
   * Declares the field of the player name to the
   * CSV handler.
   */
  public static final String DECLARE_NAME = "Name";

  /**
   * Declares the field of the player piece to the
   * CSV handler.
   */
  public static final String DECLARE_PIECE = "Piece";

  // Constants for Snakes and Ladders

  /**
   * The name of the Snakes and Ladders board.
   */
  public static final String SNL_BOARD = "snl";
  /**
   * The name of the Classic Snakes and Ladders board in the game.
   */
  public static final String SNL_BOARD_NAME_CLASSIC = "Classic";
  /**
   * The name of the Twister Snakes and Ladders board in the game.
   */
  public static final String SNL_BOARD_NAME_TWISTER = "Twister";
  /**
   * The name of the Canyon Snakes and Ladders board in the game.
   */
  public static final String SNL_BOARD_NAME_CANYON = "Canyon";
  /**
   * Width of the Snakes and Ladders Board.
   */
  public static final int SNL_WIDTH = 10;
  /**
   * Height of the Snakes and Ladders Board.
   */
  public static final int SNL_HEIGHT = 9;
  /**
   * Snake tile type.
   */
  public static final String SNAKE = "SNAKE";
  /**
   * Ladder tile type.
   */
  public static final String LADDER = "LADDER";
  /**
   * Switch tile type.
   */
  public static final String SWITCH = "SWITCH";
  /**
   * Normal tile type.
   */
  public static final String NORMAL = "NORMAL";
  /**
   * List of valid board names.
   */
  public static final List<String> BOARD_NAMES = List.of(
      SNL_BOARD_NAME_CLASSIC,
      SNL_BOARD_NAME_TWISTER,
      SNL_BOARD_NAME_CANYON
  );
  /**
   * Private constructor to prevent instantiation.
   * Throws IllegalStateException if called.
   */
  private Constants() {
    throw new IllegalStateException("Should not be instantiated");
  }
}
