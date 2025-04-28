package gameengine.grid;

import gameengine.board.Board;

/**
 * Abstract base for grid-based boards (rows x cols).
 * Manages a 2D array of cells.
 */
public abstract class GridBoard extends Board {
  protected final int rows;
  protected final int cols;
  protected final Cell[][] cells;

  /**
   * Constructs a grid board of given size.
   * @param gridRows number of rows
   * @param gridCols number of columns
   */
  public GridBoard(final int gridRows, final int gridCols) {
    super(gridCols, gridRows);
    this.rows = gridRows;
    this.cols = gridCols;
    this.cells = new Cell[rows][cols];
    initCells();
  }

  private void initCells() {
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        cells[r][c] = new Cell(r, c);
      }
    }
  }

  /**
   * @return number of rows
   */
  public int getRows() {
    return rows;
  }
  /**
   * @return number of columns
   */
  public int getCols() {
    return cols;
  }

  /**
   * Gets the cell at the specified coordinates.
   * @param row row index
   * @param col column index
   * @return the Cell at (row, col)
   * @throws IndexOutOfBoundsException if invalid
   */
  public Cell getCell(final int row, final int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols) {
      throw new IndexOutOfBoundsException("Invalid cell coordinates");
    }
    return cells[row][col];
  }

  @Override
  public String getName() {
    return String.format("Grid[%dx%d]", rows, cols);
  }
}