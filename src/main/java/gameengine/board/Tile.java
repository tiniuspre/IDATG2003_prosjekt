package gameengine.board;

/**
 * The {@code Tile} class represents the tiles of the board in the game engine.
 * It contains the state and behavior of the game tiles.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */

public abstract class Tile {
  /**
   * The number of the tile.
   */
  private int number;
  /**
   * The action of the tile.
   */
  private TileAction action;
  /**
   * The x position of the tile.
   */
  private int posX;
  /**
   * The y position of the tile.
   */
  private int posY;

  /**
   * Constructs a new {@code Tile} object
   * with the specified number, pos_x and pos_y.
   *
   * @param num the number of the tile.
   * @param positionX the x position of the tile.
   * @param positionY the y position of the tile.
   */
  public Tile(final int num, final int positionX, final int positionY) {
    setNumber(num);
    setPosX(positionX);
    setPosY(positionY);
  }

  /**
   * Accessor method for the action of the tile.
   *
   * @return the action of the tile.
   */
  public final TileAction getAction() {
    return action;
  }

  /**
   * Sets the action of the tile.
   *
   * @param tileAction the action of the tile.
   * @throws IllegalArgumentException if the input action is null.
   */
  public final void setAction(final TileAction tileAction)
      throws IllegalArgumentException {
    if (tileAction == null) {
      throw new IllegalArgumentException("Action of the tile cannot be null.");
    }
    this.action = tileAction;
  }

  /**
   * Accessor method for the number of the tile.
   *
   * @return the number of the tile.
   */
  public int getNumber() {
    return number;
  }

  /**
   * Accessor method for the x position of the tile.
   *
   * @return the x position of the tile.
   */
  public int getPosX() {
    return posX;
  }

  /**
   * Accessor method for the y position of the tile.
   *
   * @return the y position of the tile.
   */
  public int getPosY() {
    return posY;
  }

  /**
   * Sets the x position of the tile.
   *
   * @param inputPosX the input x position of the tile.
   * @throws IllegalArgumentException if the x position is less than 0.
   */
  public void setPosX(final int inputPosX) throws IllegalArgumentException {
    if (inputPosX < 0) {
      throw new IllegalArgumentException("Invalid x position of tile.");
    }
    this.posX = inputPosX;
  }

  /**
   * Sets the y position of the tile.
   *
   * @param inputPosY the input y position of the tile.
   * @throws IllegalArgumentException if the y position is less than 0.
   */
  public void setPosY(final int inputPosY) throws IllegalArgumentException {
    if (inputPosY < 0) {
      throw new IllegalArgumentException("Invalid y position of tile.");
    }
    this.posY = inputPosY;
  }

  /**
   * Sets the number of the tile.
   *
   * @param inputNumber the input number of the tile.
   * @throws IllegalArgumentException if the number is less than 0.
   */
  public void setNumber(final int inputNumber) throws IllegalArgumentException {
    if (inputNumber < 0) {
      throw new IllegalArgumentException("Invalid number of tile.");
    }
    this.number = inputNumber;
  }
}
