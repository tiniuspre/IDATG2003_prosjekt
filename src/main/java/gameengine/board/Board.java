package gameengine.board;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * The {@code Board} class represents the game board in the game engine.
 * It contains the state and behavior of the game board.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */

public abstract class Board {
  /**
   * The width of the board.
   */
  private int width;
  /**
   * The height of the board.
   */
  private int height;
  /**
   * The name of the board.
   */
  private String name;
  /**
   * Constructs a new {@code Board} object
   * with the specified inputWidth and inputHeight.
   *
   * @param inputWidth the inputWidth of the board.
   * @param inputHeight the inputHeight of the board.
   */
  public Board(final int inputWidth, final int inputHeight) {
    setWidth(inputWidth);
    setHeight(inputHeight);
  }

  /**
   * Default constructor for the Board class.
   */
  public Board() {
    // Default constructor
  }
  /**
   * Sets the width of the board.
   *
   * @param inputWidth the width of the board.
   * @throws IllegalArgumentException if the width is less than 0.
   */
  public void setWidth(final int inputWidth) throws IllegalArgumentException {
    if (inputWidth < 0) {
      throw new IllegalArgumentException("Invalid board width.");
    }
    this.width = inputWidth;
  }
  /**
   * Sets the height of the board.
   *
   * @param inputHeight the height of the board.
   * @throws IllegalArgumentException if the height is less than 0.
   */
  public void setHeight(final int inputHeight) throws IllegalArgumentException {
    if (inputHeight < 0) {
      throw new IllegalArgumentException("Invalid height width");
    }
    this.height = inputHeight;
  }

  /**
   * Accessor method for the width of the board.
   *
   * @return the width of the board.
   */
  public final int getWidth() {
    return width;
  }

  /**
   * Accessor method for the height of the board.
   *
   * @return the height of the board.
   */
  public final int getHeight() {
    return height;
  }

  /**
   * Accessor method for the name of the board.
   *
   * @return the name of the board.
   */
  public final String getName() {
    return name;
  }

  /**
   * Sets the name of the board.
   *
   * @param inputName the name of the board.
   * @throws IllegalArgumentException if the name is null or empty.
   */
  @JsonSetter("name")
  public void setName(final String inputName) throws IllegalArgumentException {
    if (inputName == null || inputName.isBlank()) {
      throw new IllegalArgumentException("Invalid name of board.");
    }
    this.name = inputName;
  }
}
