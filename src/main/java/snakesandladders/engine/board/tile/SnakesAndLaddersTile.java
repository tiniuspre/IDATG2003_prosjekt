package snakesandladders.engine.board.tile;

import constants.Constants;
import gameengine.board.tile.Tile;

public class SnakesAndLaddersTile extends Tile {
  /**
   * The type of the tile.
   */
  private String type;

  private int next;

  /**
   * Constructor for the SnakesAndLaddersTile class.
   *
   * @param inputPosition the position of the tile.
   * @param inputType     the type of the tile.
   */
  public SnakesAndLaddersTile(final int inputPosition,
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

  public int getNext() {
    return next;
  }

  public void setNext(final int next) {
    if (next < 0) {
      throw new IllegalArgumentException("Invalid tile position.");
    } else if ( next > getPosition() && type.equals(Constants.SNAKE) ) {
      throw new IllegalArgumentException("Invalid snake position.");
    } else if ( next < getPosition() && type.equals(Constants.LADDER) ) {
      throw new IllegalArgumentException("Invalid ladder position.");
    }
    this.next = next;
  }
}
