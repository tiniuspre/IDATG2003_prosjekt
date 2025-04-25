package snakesandladders.engine.board.tile;

import gameengine.board.tile.Tile;

public class SnakesAndLaddersTile extends Tile {
  /**
   * The type of the tile.
   */
  private String type;

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
}
