package snakesandladders.engine.board;

import constants.Constants;
import filehandler.jsonhandling.JsonHandler;
import filehandler.jsonhandling.JsonHandlerException;

import java.io.IOException;
import java.util.List;

/**
 * Utility class for loading a Snakes and Ladders board from a JSON file.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 14.04.2025
 * @see SnLBoard
 */
public final class SnLLoader {
  /**
   * Private constructor to prevent instantiation.
   */
  private SnLLoader() {
    // Prevent instantiation
  }
  /**
   * Loads a Snakes and Ladders board by its name from a JSON file.
   *
   * @param boardName The name of the board to load.
   * @return The SnakesAndLaddersBoard object
   *        corresponding to the specified board name.
   * @throws IllegalArgumentException If the board is not found
   *        or the JSON file is invalid.
   * @throws JsonHandlerException If there is an error
   *        while processing the JSON file.
   */
  public static SnLBoard loadBoard(final String boardName) {
    // Declare the JsonHandler and boardConfigs variables
    JsonHandler jsonHandler;
    List<SnLBoardConfig> boardConfigs;
    try {
      // Creates a handler for the JSON file containing the boards
      jsonHandler = new JsonHandler("boards/snl/"
          + boardName + ".json");
      // Reads the list of all boards from the JSON file
      boardConfigs = jsonHandler
          .readFromFile(SnLBoardConfig.class);
    } catch (IOException e) {
      throw new SnLBoardException("Failed to create JSON handler: "
          + e.getMessage());
    }
    // Checks if the boardConfigs list is null or empty
    if (boardConfigs == null) {
      throw new JsonHandlerException(
          "Failed to load the boards from JSON file.");
    } else if (boardConfigs.isEmpty()) {
      throw new JsonHandlerException("No boards found in JSON file.");
    }
    // Creates the board using the first board configuration
    try {
      return new SnLBoard(Constants.SNL_WIDTH,
          Constants.SNL_HEIGHT,
          boardConfigs.getFirst());
    } catch (IllegalArgumentException e) {
      throw new SnLBoardException("Invalid board configuration: "
          + e.getMessage());
    } catch (JsonHandlerException e) {
      throw new SnLBoardException(
          "Error getting board when processing JSON file: " + e.getMessage());
    }
  }
}
