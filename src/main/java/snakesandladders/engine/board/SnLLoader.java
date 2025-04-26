package snakesandladders.engine.board;

import constants.Constants;
import filehandler.jsonhandling.JsonHandler;
import gameengine.board.BoardLoader;

import java.util.List;

/**
 * Utility class for loading a Snakes and Ladders board from a JSON file.
 *
 * @author jonastomren
 * @version 25.04.2025
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
   * @return The SnLBoard object
   *        corresponding to the specified board name.
   * @throws SnLBoardException If the board is not found
   *        or the JSON file is invalid.
   */
  public static SnLBoard loadBoard(final String boardName) {
    if (boardName == null || boardName.isEmpty()) {
      throw new SnLBoardException("Board name cannot be null or empty");
    }
    // get board loader
    JsonHandler jsonHandler = new JsonHandler("boards/boards.json");
    List<BoardLoader> boardLoaders = jsonHandler
        .readFromFile(BoardLoader.class);
    BoardLoader boardLoader = boardLoaders.get(0);
    // get board according to board name
    SnLBoardConfig boardConfig = boardLoader.getSnLBoards().filter(board ->
        board.getBoardName().equals(boardName)).findFirst()
        .orElseThrow(() -> new SnLBoardException(
            "Board not found: " + boardName));
    // create board
    return new SnLBoard(Constants.SNL_WIDTH, Constants.SNL_HEIGHT,
        boardConfig);
  }
}
