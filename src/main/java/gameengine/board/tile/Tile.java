package gameengine.board.tile;

public abstract class Tile {
  /**
   * The position of the tile on the board.
   */
  private int position;

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
}
