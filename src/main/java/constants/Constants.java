package constants;

/**
 * Utility class containing constants.
 * This class should not be instantiated.
 *
 * @since 25.03.2025
 * @version 25.03.2025
 * @author tinius
 */
public final class Constants {

  // File paths
  public static final String SNL_BOARD_FILE_PATH = "json-files/snakes_board.json";
  public static final String SNL_PLAYER_FILE_PATH = "json-files/snakes_players.csv";
  public static final String SNL_PLAYER_FILE_PATH_TEST = "src/test/resources/json-files/snakes_players_test.csv";
  Constants() {
    throw new IllegalStateException("Should not be instantiated");
  }
}
