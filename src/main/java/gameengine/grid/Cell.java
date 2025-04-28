package gameengine.grid;

import gameengine.board.tile.Tile;

/**
 * Represents a cell on a grid-based board (row, column).
 */
public class Cell extends Tile {
  private final int row;
  private final int col;

  /**
   * Constructs a Cell at given grid coordinates.
   * @param row the row index (0-based)
   * @param col the column index (0-based)
   */
  public Cell(int row, int col) {
    super(row * col); // position can be computed or unused
    this.row = row;
    this.col = col;
  }

  /**
   * @return row index of this cell
   */
  public int getRow() {
    return row;
  }
  /**
   * @return column index of this cell
   */
  public int getCol() {
    return col;
  }
}

