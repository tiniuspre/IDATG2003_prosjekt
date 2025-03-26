package snakesandladders.engine.tiles;

import gameengine.board.Tile;
import gameengine.board.TileAction;

/**
 * The {@code TestGameTile} class represents the game tile in the test game.
 */
public class SnakesAndLaddersTile extends Tile {

  private TileAction tileAction;

  /**
   * Constructor for the TestGameTile class.
   *
   * @param number the number of the tile.
   * @param posX the x position of the tile.
   * @param posY the y position of the tile.
   */
  public SnakesAndLaddersTile(final int number, final int posX,
                              final int posY, TileAction tileAction ) {
    super(number, posX, posY);
  }

  public SnakesAndLaddersTile(final int number, final int posX,
                              final int posY) {
    super(number, posX, posY);
  }

  public void setTileAction(TileAction inputAction) {
    if (inputAction == null) {
      throw new IllegalArgumentException("Action cannot be null");
    }
    this.tileAction = inputAction;
  }

  public TileAction getTileAction() {
    return tileAction;
  }

}


