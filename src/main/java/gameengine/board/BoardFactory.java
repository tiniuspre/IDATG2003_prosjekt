package gameengine.board;

import filehandler.jsonhandling.JsonHandlerException;
import snakesandladders.engine.board.SnLBoardException;
import snakesandladders.engine.board.SnLLoader;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * The {@code BoardFactory} class is a factory class
 * for creating game boards.
 *
 * @author jonastomren
 * @version 15.04.2025
 * @since 15.04.2025
 * @see Board
 */
public final class BoardFactory {
  /**
   * Logger for logging errors and information.
   */
  private static final Logger LOGGER = Logger
      .getLogger(BoardFactory.class.getName());

  /**
   * Private constructor to prevent instantiation.
   */
  private BoardFactory() {
    // Private constructor to prevent instantiation
  }

  /**
   * Creates a board based on the specified board type and name.
   *
   * @param boardType the type of the board (e.g., "snl").
   * @param boardName the name of the board (e.g., "Classic").
   * @return an Optional containing the created board,
   *        empty if none is found.
   */
  public static Optional<Board> createBoard(final String boardType,
                                            final String boardName) {
    try {
      // To be extended with more cases
      return switch (boardType) {
        case "snl" -> Optional.of(SnLLoader.loadBoard(boardName));
        default -> Optional.empty();
      };
    } catch (JsonHandlerException | SnLBoardException e) {
      return Optional.empty();
    } catch (Exception e) {
      LOGGER.log(java.util.logging.Level.SEVERE,
          "Unexpected error while loading board: " + e.getMessage(), e);
      return Optional.empty();
    }
  }
}
