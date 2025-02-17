package gameengine.board;

import org.jetbrains.annotations.NotNull;

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
  private final int number;
  /**
   * The action of the tile.
   */
  private TileAction action;
  /**
   * The x position of the tile.
   */
  private final int posX;
  /**
   * The y position of the tile.
   */
  private final int posY;

  /**
   * Constructs a new {@code Tile} object
   * with the specified number, pos_x and pos_y.
   *
   * @param num the number of the tile.
   * @param positionX the x position of the tile.
   * @param positionY the y position of the tile.
   */
  public Tile(final int num, final int positionX, final int positionY) {
    this.number = num;
    this.posX = positionX;
    this.posY = positionY;
  }

  public final int getNumber() {
    return number;
  }

  public final TileAction getAction() {
    return action;
  }

  public final void setAction(@NotNull final TileAction tileAction) {
    this.action = tileAction;
  }

  public final int getPosX() {
    return posX;
  }

  public final int getPosY() {
    return posY;
  }
}
