package snakesandladders.engine;

import filehandler.jsonhandling.JsonHandler;
import filehandler.jsonhandling.JsonHandlerException;

import java.io.IOException;
import java.util.List;

public class SnakesLaddersLoader {

  public static SnakesAndLaddersBoard loadBoard(final String boardName) throws IOException {
    // creates a handler based on the input selected board
    JsonHandler jsonHandler = new JsonHandler("boards/snl/snl_boards.json");
    // gets the list of all boards from the json file
    List<SnakesAndLaddersBoard> board = jsonHandler.readFromFile(SnakesAndLaddersBoard.class);
    // checks if the board is null or empty
    if (board == null) {
      throw new IllegalArgumentException("Failed to load the board from JSON file.");
    } else if (board.isEmpty()) {
      throw new JsonHandlerException("No boards found in JSON file.");
    }
    // checks if the board name exists in the list
    try {
      for (SnakesAndLaddersBoard b : board) {
        // if y then return board
        if (b.getName().equals(boardName)) {
          return b;
        }
      }
      // if n then throw exception
      throw new IllegalArgumentException("Board not found in JSON file.");
    } catch (Exception e) {
      // if an error occurs while reading the file
      throw new JsonHandlerException("Failed to load the board from JSON file.");
    }
  }
}
