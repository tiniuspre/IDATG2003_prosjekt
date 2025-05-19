package gameengine.grid;

import gameengine.board.Board;

/**
 * Abstract base for grid-based boards (rows x cols).
 * This class manages a 2D array of cells and
 * provides methods to access and manipulate the grid.
 * It serves as a foundation for implementing specific grid-based game boards.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public abstract class GridBoard extends Board {
  /**
   * The number of rows in the grid.
   */
  private final int rows;

  /**
   * The number of columns in the grid.
   */
  private final int cols;

  /**
   * A 2D array representing the cells of the grid.
   */
  private final Cell[][] cells;

  /**
   * Constructs a grid board of the specified size.
   * Initializes the grid with the given number of rows and columns.
   *
   * @param gridRows the number of rows in the grid
   * @param gridCols the number of columns in the grid
   */
  public GridBoard(final int gridRows, final int gridCols) {
    super(gridCols, gridRows);
    this.rows = gridRows;
    this.cols = gridCols;
    this.cells = new Cell[rows][cols];
    initCells();
  }

  /**
   * Initializes the cells of the grid.
   * Creates a new Cell object for each position in the grid.
   */
  private void initCells() {
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        cells[r][c] = new Cell(r, c);
      }
    }
  }

  /**
   * Gets the number of rows in the grid.
   *
   * @return the number of rows
   */
  public int getRows() {
    return rows;
  }

  /**
   * Gets the number of columns in the grid.
   *
   * @return the number of columns
   */
  public int getCols() {
    return cols;
  }

  /**
   * Retrieves the cell at the specified coordinates.
   *
   * @param row the row index of the cell
   * @param col the column index of the cell
   * @return the Cell object at the specified (row, col) position
   * @throws IndexOutOfBoundsException if the specified coordinates are invalid
   */
  public Cell getCell(final int row, final int col) {
    if (row < 0 || row >= rows || col < 0 || col >= cols) {
      throw new IndexOutOfBoundsException(
          "Cell (" + row + "," + col + ") is out of bounds.");
    }
    return cells[row][col];
  }

  /**
   * Gets the entire grid of cells.
   *
   * @return a 2D array of all cells
   */
  public Cell[][] getCells() {
    return cells.clone();
  }

  /**
   * Gets the name of the grid board.
   * The name is formatted as "Grid[rows x cols]".
   *
   * @return a string representing the name of the grid board
   */
  @Override
  public String getName() {
    return "Grid[" + rows + "x" + cols + "]";
  }
}
