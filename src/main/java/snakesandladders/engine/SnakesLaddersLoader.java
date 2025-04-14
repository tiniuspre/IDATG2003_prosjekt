package snakesandladders.engine;

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
 * @see SnakesAndLaddersBoard
 */
public final class SnakesLaddersLoader {
  /**
   * Private constructor to prevent instantiation.
   */
  private SnakesLaddersLoader() {
    // Prevent instantiation
  }
  /**
   * Loads a Snakes and Ladders board by its name from a JSON file.
   *
   * @param boardName The name of the board to load.
   * @return The SnakesAndLaddersBoard object
   *        corresponding to the specified board name.
   * @throws IOException If an I/O error occurs
   *        while reading the JSON file.
   * @throws IllegalArgumentException If the board is not found
   *        or the JSON file is invalid.
   * @throws JsonHandlerException If there is an error
   *        while processing the JSON file.
   */
  public static SnakesAndLaddersBoard loadBoard(final String boardName)
      throws IOException {
    // Creates a handler for the JSON file containing the boards
    JsonHandler jsonHandler = new JsonHandler("boards/snl/snl_boards.json");
    // Reads the list of all boards from the JSON file
    List<SnakesAndLaddersBoard> board = jsonHandler
        .readFromFile(SnakesAndLaddersBoard.class);
    // Checks if the board list is null or empty
    if (board == null) {
      throw new IllegalArgumentException(
          "Failed to load the board from JSON file.");
    } else if (board.isEmpty()) {
      throw new JsonHandlerException("No boards found in JSON file.");
    }
    // Iterates through the list to find the board with the specified name
    try {
      for (SnakesAndLaddersBoard b : board) {
        // Returns the board if the name matches
        if (b.getName().equals(boardName)) {
          return b;
        }
      }
      // Throws an exception if the board name is not found
      throw new IllegalArgumentException("Board not found in JSON file.");
    } catch (Exception e) {
      // Throws an exception if an error occurs while processing the file
      throw new JsonHandlerException(
          "Failed to load the board from JSON file.");
    }
  }
}
