package connectfour.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import gameengine.grid.Cell;

class ConnectFourBoardTest {

  @Test
  void createsBoardWithFixed4x4Dimensions() {
    ConnectFourBoard board = new ConnectFourBoard();
    Assertions.assertEquals(7, board.getRows());
    Assertions.assertEquals(7, board.getCols());
    Assertions.assertEquals(7, board.getCells().length);
    Assertions.assertEquals(7, board.getCells()[0].length);
  }

  @Test
  void retrievesCellWithinBounds() {
    ConnectFourBoard board = new ConnectFourBoard();
    Cell cell = board.getCell(3, 3);
    Assertions.assertNotNull(cell);
    Assertions.assertEquals(3, cell.getRow());
    Assertions.assertEquals(3, cell.getCol());
  }

  @Test
  void throwsExceptionWhenAccessingCellOutOfBounds() {
    ConnectFourBoard board = new ConnectFourBoard();
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(8, 0));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, 8));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(-8, 0));
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getCell(0, -8));
  }

  @Test
  void getNameReturnsCorrectFormatForConnectFourBoard() {
    ConnectFourBoard board = new ConnectFourBoard();
    Assertions.assertEquals("Grid[7x7]", board.getName());
  }
}