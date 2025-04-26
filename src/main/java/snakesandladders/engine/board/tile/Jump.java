package snakesandladders.engine.board.tile;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import snakesandladders.engine.board.SnLBoardException;

/**
 * The {@code Jump} class represents a jump on the Snakes and Ladders
 * board.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 25.04.2025
 */
public class Jump {
  /**
   * The starting position of the jump.
   */
  private int from;
  /**
   * The ending position of the jump.
   */
  private int to;

  /**
   * Constructor for the Jump class.
   *
   * @param inputFrom the starting position of the jump.
   * @param inputTo   the ending position of the jump.
   */
  public Jump(final int inputFrom, final int inputTo) {
    setFrom(inputFrom);
    setTo(inputTo);
  }

  /**
   * Default constructor for the Jump class.
   * Only to be used for file handling.
   */
  @JsonCreator
  public Jump() {
    // Default constructor
  }

  /**
   * Gets the ending position of the jump.
   *
   * @return the ending position of the jump.
   */
  @JsonGetter("to")
  public int getTo() {
    return to;
  }

  /**
   * Gets the starting position of the jump.
   *
   * @return the starting position of the jump.
   */
  @JsonGetter("from")
  public int getFrom() {
    return from;
  }

  /**
   * Sets the starting position of the jump.
   *
   * @param inputFrom the starting position of the jump.
   */
  @JsonSetter("from")
  public void setFrom(final int inputFrom) {
    if (inputFrom < 0) {
      throw new SnLBoardException("Invalid jump position.");
    }
    this.from = inputFrom;
  }

  /**
   * Sets the ending position of the jump.
   *
   * @param inputTo the ending position of the jump.
   */
  @JsonSetter("to")
  public void setTo(final int inputTo) {
    if (inputTo < 0) {
      throw new SnLBoardException("Invalid jump position.");
    }
    this.to = inputTo;
  }
}
