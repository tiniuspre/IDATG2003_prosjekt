package gameengine.board;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import snakesandladders.engine.board.SnLBoardConfig;
import snakesandladders.engine.board.SnLBoardException;

import java.util.List;
import java.util.stream.Stream;

/**
 * The {@code BoardLoader} class is responsible for loading
 * the configuration of the game boards. After use
 * the dedicated game loaders should be used to load
 * each individual board.
 *
 * @author jonastomren
 * @version 26.04.2025
 * @since 26.04.2025
 */
public class BoardLoader {
  /**
   * The list of Snakes and Ladders boards.
   */
  private List<SnLBoardConfig> snLBoards;

  /**
   * Default constructor for the {@code BoardLoader} class.
   * This constructor is used for JSON deserialization.
   */
  @JsonCreator
  public BoardLoader() {
    // Constructor logic if needed
  }

  /**
   * Gets a stream of snakes and ladders
   * board configurations.
   *
   * @return a stream of SnLBoardConfig objects
   */
  @JsonIgnore
  public Stream<SnLBoardConfig> getSnLBoards() {
    return snLBoards.stream();
  }

  /**
   * Gets the list of Snakes and Ladders boards
   * in JSON format.
   *
   * @return a list of SnLBoardConfig objects
   */
  @JsonGetter("snLBoards")
  public List<SnLBoardConfig> getSnLBoardsJson() {
    return snLBoards;
  }

  /**
   * Sets the list of Snakes and Ladders boards
   * configurations.
   *
   * @param boardConfigs the list of SnLBoardConfig objects
   */
  @JsonSetter("boardConfigs")
  public void setSnLBoards(final List<SnLBoardConfig> boardConfigs) {
    if (boardConfigs == null || boardConfigs.isEmpty()) {
      throw new SnLBoardException(
          "The list of SnLBoards cannot be null or empty.");
    }
    this.snLBoards = boardConfigs;
  }

}
