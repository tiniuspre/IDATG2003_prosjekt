package constants;

/**
 * Utility class containing constants.
 * This class should not be instantiated.
 *
 * @author tiniuspre, jonastomren
 * @version 31.03.2025
 * @since 25.03.2025
 */
public final class Constants {

  // File paths
  /**
   * Path to the Snakes and Ladders board JSON file.
   */
  public static final String SNL_BOARD_FILE_PATH =
      "json-files/snakes_board.json";

  /**
   * Path to the Snakes and Ladders players CSV file.
   */
  public static final String SNL_PLAYER_FILE_PATH =
      "csv-files/snakes_players.csv";

  /**
   * Path to the test Snakes and Ladders players CSV file.
   */
  public static final String SNL_PLAYER_FILE_PATH_TEST =
      "src/test/resources/csv-files/snakes_players_test.csv";

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
  /**
   * Private constructor to prevent instantiation.
   * Throws IllegalStateException if called.
   */
  private Constants() {
    throw new IllegalStateException("Should not be instantiated");
  }
}
