package testgame.engine;

import gameengine.board.Tile;

/**
 * The {@code TestGameTile} class represents the game tile in the test game.
 */
public class TestGameTile extends Tile {

  /**
   * Constructor for the TestGameTile class.
   *
   * @param number the number of the tile.
   * @param posX the x position of the tile.
   * @param posY the y position of the tile.
   */
  public TestGameTile(final int number, final int posX, final int posY) {
    super(number, posX, posY);
  }
}

class SnakeTile extends TestGameTile {

  private int destinationX;
  private int destinationY;

  SnakeTile(final int number, final int posX, final int posY) {
    super(number, posX, posY);
  }

  public void setDestination(final int positionX, final int positionY) {
    this.destinationX = positionX;
    this.destinationY = positionY;
  }

  public int[] getDestination() {
    return new int[] {destinationX, destinationY};
  }
}

class LadderTile extends TestGameTile {

  private int destinationX;
  private int destinationY;

  LadderTile(final int number, final int posX, final int posY) {
    super(number, posX, posY);
  }

  public void setDestination(final int positionX, final int positionY) {
    this.destinationX = positionX;
    this.destinationY = positionY;
  }

  public int[] getDestination() {
    return new int[] {destinationX, destinationY};
  }

}

class NormalTile extends TestGameTile {

  NormalTile(final int number, final int posX, final int posY) {
    super(number, posX, posY);
  }
}
