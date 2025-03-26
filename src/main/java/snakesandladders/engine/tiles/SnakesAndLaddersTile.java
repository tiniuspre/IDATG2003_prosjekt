package snakesandladders.engine.tiles;

import gameengine.board.Tile;
import gameengine.board.TileAction;
import java.util.List;
import snakesandladders.engine.SnakesAndLaddersPlayer;


/**
 * The {@code TestGameTile} class represents the game tile in the test game.
 */
public class SnakesAndLaddersTile extends Tile {
  /**
   * The action of the tile.
   */
  private TileAction<SnakesAndLaddersPlayer,
      List<SnakesAndLaddersPlayer>> tileAction;

  /**
   * Constructor for the SnakesAndLaddersTile class.
   *
   * @param number the number of the tile.
   * @param posX the x position of the tile.
   * @param posY the y position of the tile.
   * @param inputAction the action of the tile.
   */
  public SnakesAndLaddersTile(final int number, final int posX,
                              final int posY,
                              final TileAction<SnakesAndLaddersPlayer,
          List<SnakesAndLaddersPlayer>> inputAction) {
    super(number, posX, posY);
    setTileAction(inputAction);
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
  public void setTileAction(final TileAction<SnakesAndLaddersPlayer,
      List<SnakesAndLaddersPlayer>> inputAction) {
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
  public TileAction<SnakesAndLaddersPlayer,
      List<SnakesAndLaddersPlayer>> getTileAction() {
    return tileAction;
  }

}


