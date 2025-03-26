package snakesandladders.engine.tiles;

import gameengine.board.Tile;
import gameengine.board.TileAction;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.List;

/**
 * The {@code TestGameTile} class represents the game tile in the test game.
 */
public class SnakesAndLaddersTile extends Tile {

  private TileAction<SnakesAndLaddersPlayer, List<SnakesAndLaddersPlayer>> tileAction;

  /**
   * Constructor for the SnakesAndLaddersTile class.
   *
   * @param number the number of the tile.
   * @param posX the x position of the tile.
   * @param posY the y position of the tile.
   * @param tileAction the action of the tile.
   */
  public SnakesAndLaddersTile(final int number, final int posX,
                              final int posY, TileAction<SnakesAndLaddersPlayer, List<SnakesAndLaddersPlayer>> tileAction ) {
    super(number, posX, posY);
    setTileAction(tileAction);
  }

  /**
   * Constructor for the SnakesAndLaddersTile class.
   *
   * @param number the number of the tile.
   * @param posX the x position of the tile.
   * @param posY the y position of the tile.
   */
  public SnakesAndLaddersTile(final int number, final int posX,
                              final int posY) {
    super(number, posX, posY);
  }

  /**
   * Sets the action of the tile.
   *
   * @param inputAction the action of the tile.
   */
  public void setTileAction(TileAction<SnakesAndLaddersPlayer, List<SnakesAndLaddersPlayer>> inputAction) {
    if (inputAction == null) {
      throw new IllegalArgumentException("Action cannot be null");
    }
    this.tileAction = inputAction;
  }

  /**
   * Returns the action of the tile.
   *
   * @return the action of the tile.
   */
  public TileAction<SnakesAndLaddersPlayer, List<SnakesAndLaddersPlayer>> getTileAction() {
    return tileAction;
  }

}


