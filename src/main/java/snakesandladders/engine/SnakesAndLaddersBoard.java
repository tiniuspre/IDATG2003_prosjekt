package snakesandladders.engine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import gameengine.board.Board;

import java.util.List;
import java.util.Map;

/**
 * The {@code TestGameBoard} class represents the game board in the test game,
 * extending the {@code Board} class.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see Board
 */
public class SnakesAndLaddersBoard extends Board {

  private Map<Integer, Integer> snakes;

  private Map<Integer, Integer> ladders;

  private List<Integer> switches;

  private Integer size;

  /**
   * Constructor for the TestGameBoard class.
   *
   * @param width the width of the board.
   * @param height  the height of the board.
   */
  public SnakesAndLaddersBoard(final int width, final int height) {
    super(width, height);
  }

  /**
   * Default constructor for the SnakesAndLaddersBoard class.
   * Used exclusively for JSON deserialization.
   */
  @JsonCreator
  public SnakesAndLaddersBoard() {
  }
  @JsonSetter("snakes")
  public void setSnakes(final Map<Integer, Integer> inputSnakes) {
    this.snakes = inputSnakes;
  }
  @JsonGetter("snakes")
  public Map<Integer, Integer> getSnakes() {
    return snakes;
  }
  @JsonSetter("ladders")
  public void setLadders(final Map<Integer, Integer> inputLadders) {
    this.ladders = inputLadders;
  }
  @JsonGetter("ladders")
  public Map<Integer, Integer> getLadders() {
    return ladders;
  }
  @JsonSetter("size")
  public void setSize(final int inputSize) {
    this.size = inputSize;
  }
  @JsonSetter("switches")
  public void setSwitches(final List<Integer> inputSwitches) {
    this.switches = inputSwitches;
  }
  @JsonGetter("switches")
  public List<Integer> getSwitches() {
    return switches;
  }

  /**
   * Returns the size of the board.
   *
   * @return the size of the board.
   */
  @JsonGetter("size")
  public int getBoardSize() {
    return size;
  }
}
