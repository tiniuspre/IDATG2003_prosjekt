package snakesandladders.engine.board.tile;

import constants.Constants;
import gameengine.board.tile.Tile;
import snakesandladders.engine.board.SnLBoardException;

public class SnLTile extends Tile {
  /**
   * The type of the tile.
   */
  private String type;
  /**
   * The next tile to jump to.
   */
  private int next;

  /**
   * Constructor for the SnakesAndLaddersTile class.
   *
   * @param inputPosition the position of the tile.
   * @param inputType     the type of the tile.
   */
  public SnLTile(final int inputPosition,
                 final String inputType) {
    super(inputPosition);
    setType(inputType);
  }

  /**
   * Sets the type of the tile.
   *
   * @param inputType the type of the tile.
   */
  public void setType(final String inputType) {
    this.type = inputType;
  }

  /**
   * Gets the type of the tile.
   *
   * @return the type of the tile.
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the next tile to jump to.
   *
   * @return the next tile to jump to.
   */
  public int getNext() {
    return next;
  }

  /**
   * Sets the inputNext tile to jump to.
   *
   * @param inputNext the inputNext tile to jump to.
   * @throws IllegalArgumentException if the inputNext tile is invalid.
   */
  public void setNext(final int inputNext) {
    if (inputNext < 0) {
      throw new SnLBoardException("Invalid tile position.");
    } else if (inputNext > getPosition() && type.equals(Constants.SNAKE)) {
      throw new SnLBoardException("Invalid snake position.");
    } else if (inputNext < getPosition() && type.equals(Constants.LADDER)) {
      throw new SnLBoardException("Invalid ladder position.");
    }
    this.next = inputNext;
  }
}
