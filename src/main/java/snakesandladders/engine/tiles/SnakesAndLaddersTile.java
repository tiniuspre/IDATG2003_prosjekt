package snakesandladders.engine.tiles;

import gameengine.board.Tile;

/**
 * The {@code TestGameTile} class represents the game tile in the test game.
 */
public class SnakesAndLaddersTile extends Tile {

  /**
   * Constructor for the TestGameTile class.
   *
   * @param number the number of the tile.
   * @param posX the x position of the tile.
   * @param posY the y position of the tile.
   */
  public SnakesAndLaddersTile(final int number, final int posX,
                              final int posY) {
    super(number, posX, posY);
  }

}


