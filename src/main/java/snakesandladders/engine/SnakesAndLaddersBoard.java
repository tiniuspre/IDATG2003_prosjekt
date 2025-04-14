package snakesandladders.engine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import gameengine.board.Board;
import java.util.List;
import java.util.Map;

/**
 * The {@code SnakesAndLaddersBoard} class represents
 * the game board for the Snakes and Ladders game.
 * It extends the {@code Board} class and includes
 * additional properties such as snakes, ladders, switches, and size.
 * This class is designed to be compatible
 * with JSON serialization and deserialization.
 *
 * @see Board
 */
public class SnakesAndLaddersBoard extends Board {
  /**
   * The map of snakes on the board.
   */
  private Map<Integer, Integer> snakes;
  /**
   * The map of ladders on the board.
   */
  private Map<Integer, Integer> ladders;
  /**
   * The list of positions on the board that act as switches.
   */
  private List<Integer> switches;
  /**
   * The size of the board.
   */
  private Integer size;

  /**
   * Constructor for the {@code SnakesAndLaddersBoard} class.
   *
   * @param width the width of the board.
   * @param height the height of the board.
   */
  public SnakesAndLaddersBoard(final int width, final int height) {
    super(width, height);
  }

  /**
   * Default constructor for the {@code SnakesAndLaddersBoard} class.
   * Used exclusively for JSON deserialization.
   */
  @JsonCreator
  public SnakesAndLaddersBoard() {
  }

  /**
   * Sets the snakes on the board.
   *
   * @param inputSnakes a map where keys are the start
   *                   positions of snakes and values are the end positions.
   */
  @JsonSetter("snakes")
  public void setSnakes(final Map<Integer, Integer> inputSnakes) {
    this.snakes = inputSnakes;
  }

  /**
   * Gets the snakes on the board.
   *
   * @return a map where keys are the start
   *        positions of snakes and values are the end positions.
   */
  @JsonGetter("snakes")
  public Map<Integer, Integer> getSnakes() {
    return snakes;
  }

  /**
   * Sets the ladders on the board.
   *
   * @param inputLadders a map where keys are the start
   *                    positions of ladders and values are the end positions.
   */
  @JsonSetter("ladders")
  public void setLadders(final Map<Integer, Integer> inputLadders) {
    this.ladders = inputLadders;
  }

  /**
   * Gets the ladders on the board.
   *
   * @return a map where keys are the start
   *        positions of ladders and values are the end positions.
   */
  @JsonGetter("ladders")
  public Map<Integer, Integer> getLadders() {
    return ladders;
  }

  /**
   * Sets the size of the board.
   *
   * @param inputSize the size of the board.
   */
  @JsonSetter("size")
  public void setSize(final int inputSize) {
    this.size = inputSize;
  }

  /**
   * Sets the switches on the board.
   *
   * @param inputSwitches a list of positions
   *                     on the board that act as switches.
   */
  @JsonSetter("switches")
  public void setSwitches(final List<Integer> inputSwitches) {
    this.switches = inputSwitches;
  }

  /**
   * Gets the switches on the board.
   *
   * @return a list of positions on the board that act as switches.
   */
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
