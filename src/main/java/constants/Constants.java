package constants;

/**
 * Utility class containing constants.
 * This class should not be instantiated.
 *
 * @since 25.03.2025
 * @version 25.03.2025
 * @author tinius, jonastomren
 */
public final class Constants {

  // File paths
  /**
   * Path to the Snakes and Ladders board JSON file.
   */
  public static final String SNL_BOARD_FILE_PATH = "json-files/snakes_board.json";

  /**
   * Path to the Snakes and Ladders players CSV file.
   */
  public static final String SNL_PLAYER_FILE_PATH = "csv-files/snakes_players.csv";

  /**
   * Path to the test Snakes and Ladders players CSV file.
   */
  public static final String SNL_PLAYER_FILE_PATH_TEST = "src/test/resources/csv-files/snakes_players_test.csv";

  /**
   * Private constructor to prevent instantiation.
   * Throws IllegalStateException if called.
   */
  Constants() {
    throw new IllegalStateException("Should not be instantiated");
  }
}