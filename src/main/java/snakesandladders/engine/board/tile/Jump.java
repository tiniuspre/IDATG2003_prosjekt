package snakesandladders.engine.board.tile;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Jump {
  public int from;
  public int to;

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

  public Jump() {
    // Default constructor
  }
  @JsonGetter("to")
  public int getTo() {
    return to;
  }
  @JsonGetter("from")
  public int getFrom() {
    return from;
  }
  @JsonSetter("from")
  public void setFrom(final int from) {
    if (from < 0) {
      throw new IllegalArgumentException("Invalid jump position.");
    }
    this.from = from;
  }
  @JsonSetter("to")
  public void setTo(final int to) {
    if (to < 0) {
      throw new IllegalArgumentException("Invalid jump position.");
    }
    this.to = to;
  }
}
