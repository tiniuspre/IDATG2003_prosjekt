package gameengine.grid;

import gameengine.board.tile.Tile;

/**
 * Represents a cell on a grid-based board (row, column).
 * This class extends the Tile class and provides additional functionality
 * specific to grid-based games, such as storing the row and column indices
 * of the cell.
 *
 * <p>Each cell is identified by its row and column indices, which are
 * initialized during construction and can be updated using private setters.
 * The class inherits from the Tile class, which may provide additional
 * functionality for game tiles.</p>
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public class Cell extends Tile {
  /**
   * The row index of the cell (0-based).
   */
  private int row;

  /**
   * The column index of the cell (0-based).
   */
  private int col;

  /**
   * Constructs a Cell at given grid coordinates.
   * Initializes the cell with the specified row and column indices.
   *
   * @param rowInd the row index (0-based)
   * @param colInd the column index (0-based)
   */
  public Cell(final int rowInd, final int colInd) {
    super(rowInd * colInd); // Initializes the Tile with a computed value
    setRow(rowInd);
    setCol(colInd);
  }

  /**
   * Sets the row index of the cell.
   * This method is private and used internally during construction.
   *
   * @param rowInd the new row index (0-based)
   */
  private void setRow(final int rowInd) {
    this.row = rowInd;
  }

  /**
   * Sets the column index of the cell.
   * This method is private and used internally during construction.
   *
   * @param colInd the new column index (0-based)
   */
  private void setCol(final int colInd) {
    this.col = colInd;
  }

  /**
   * Gets the row index of the cell.
   *
   * @return the row index (0-based)
   */
  public int getRow() {
    return row;
  }

  /**
   * Gets the column index of the cell.
   *
   * @return the column index (0-based)
   */
  public int getCol() {
    return col;
  }
}
