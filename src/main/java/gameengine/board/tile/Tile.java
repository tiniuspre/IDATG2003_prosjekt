package gameengine.board.tile;

/**
 * The {@code Tile} class represents a tile on the game board.
 *
 * @author jonastomren
 * @version 19.05.2025
 * @since 25.04.2025
 */
public abstract class Tile {
  /**
   * The position of the tile on the board.
   */
  private int position;
  /**
   * The x position of the tile.
   */
  private int posX;
  /**
   * The y position of the tile.
   */
  private int posY;
  /**
   * Constructor for the Tile class.
   *
   * @param inputPosition the position of the tile on the board.
   */
  public Tile(final int inputPosition) {
    setPosition(inputPosition);
  }

  /**
   * Sets the position of the tile.
   *
   * @param inputPosition the position of the tile on the board.
   * @throws IllegalArgumentException if the position is invalid.
   */
  public void setPosition(final int inputPosition)
      throws IllegalArgumentException {
    if (inputPosition < 0) {
      throw new IllegalArgumentException("Invalid tile position.");
    }
    this.position = inputPosition;
  }

  /**
   * Gets the position of the tile.
   *
   * @return the position of the tile on the board.
   */
  public int getPosition() {
    return position;
  }

  /**
   * Sets the x position of the tile.
   *
   * @param inputPosX the x position of the tile.
   */
  public void setPosX(final int inputPosX) {
    if (inputPosX < 0) {
      throw new IllegalArgumentException("Invalid tile position.");
    }
    this.posX = inputPosX;
  }

  /**
   * Gets the x position of the tile.
   *
   * @return the x position of the tile.
   */
  public int getPosX() {
    return posX;
  }

  /**
   * Sets the y position of the tile.
   *
   * @param inputPosY the y position of the tile.
   */
  public void setPosY(final int inputPosY) {
    if (inputPosY < 0) {
      throw new IllegalArgumentException("Invalid tile position.");
    }
    this.posY = inputPosY;
  }

  /**
   * Gets the y position of the tile.
   *
   * @return the y position of the tile.
   */
  public int getPosY() {
    return posY;
  }
}
