package gameengine.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GridBoardTest {

  private static class TestGridBoard extends GridBoard {
    public TestGridBoard(int rows, int cols) {
      super(rows, cols);
    }
  }

  @Test
  void createsGridWithCorrectDimensions() {
    GridBoard board = new TestGridBoard(3, 4);
    Assertions.assertEquals(3, board.getRows());
    Assertions.assertEquals(4, board.getCols());
    Assertions.assertEquals(3, board.getCells().length);
    Assertions.assertEquals(4, board.getCells()[0].length);
  }

  @Test
  void retrievesCellAtValidCoordinates() {
    GridBoard board = new TestGridBoard(2, 2);
    Cell cell = board.getCell(1, 1);
    Assertions.assertNotNull(cell);
    Assertions.assertEquals(1, cell.getRow());
    Assertions.assertEquals(1, cell.getCol());
  }

  @Test
  void throwsExceptionWhenAccessingCellWithNegativeRow() {
    GridBoard board = new TestGridBoard(2, 2);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(-1, 0));
  }

  @Test
  void throwsExceptionWhenAccessingCellWithNegativeCol() {
    GridBoard board = new TestGridBoard(2, 2);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, -1));
  }

  @Test
  void throwsExceptionWhenAccessingCellWithRowOutOfBounds() {
    GridBoard board = new TestGridBoard(2, 2);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(2, 0));
  }

  @Test
  void throwsExceptionWhenAccessingCellWithColOutOfBounds() {
    GridBoard board = new TestGridBoard(2, 2);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, 2));
  }

  @Test
  void getNameReturnsCorrectFormat() {
    GridBoard board = new TestGridBoard(5, 7);
    Assertions.assertEquals("Grid[5x7]", board.getName());
  }

  @Test
  void getCellsReturnsShallowCopyOfArray() {
    GridBoard board = new TestGridBoard(2, 2);
    Cell[][] cells1 = board.getCells();
    Cell[][] cells2 = board.getCells();
    Assertions.assertNotSame(cells1, cells2);
    Assertions.assertSame(cells1[0], cells2[0]);
  }
}